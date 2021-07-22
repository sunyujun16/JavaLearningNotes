package chap20_generics;

import java.lang.reflect.*;
import java.util.*;

import onjava.*;
import static onjava.Tuple.*;

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    @SuppressWarnings("unchecked")
    MixinProxy(Tuple2<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (Tuple2<Object, Class<?>> pair : pairs) {
            for (Method method : pair.a2.getMethods()) {
                String methodName = method.getName();
                // The first interface in the map
                // implements the method.
                if (!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName, pair.a1);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(Tuple2... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].a2;
        }
        ClassLoader cl =
                pairs[0].a1.getClass().getClassLoader();
        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}

class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(), Basic.class),
                tuple(new TimeStampedImp(), TimeStamped.class),
                tuple(new SerialNumberedImp(), SerialNumbered.class)
        );
        // 参数决定了proxy实现哪些接口, 所以下面才能够向接口转型.但只是转型到接口而已.
        // 这意味着只能使用公共接口的方法.

        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());


        // 万一这几个类包含同样的方法名咋整?
        System.out.println(b.getName()+" "+t.getName()+" "+s.getName());
        // 结果: BasicImp BasicImp BasicImp 跟我想得一样.
        // Map中键是唯一的, 所以对每个方法名称只能存储一种调用.
    }
}

public class A12_DynamicProxyMixin {
}
