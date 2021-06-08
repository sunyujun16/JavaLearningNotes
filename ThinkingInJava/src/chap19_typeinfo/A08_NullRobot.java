package chap19_typeinfo;

// Using a dynamic proxy to create an Optional

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

import onjava.*;

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private A08_Robot proxied = new NRobot();

    NullRobotProxyHandler(Class<? extends A08_Robot> type) {
        nullName = type.getSimpleName() + " A08_NullRobot";
    }

    private class NRobot implements Null, A08_Robot {
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<A08_Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return method.invoke(proxied, args);
    }
}

public class A08_NullRobot {
    public static A08_Robot newNullRobot(Class<? extends A08_Robot> type) {
        return (A08_Robot) Proxy.newProxyInstance(
                A08_NullRobot.class.getClassLoader(),
                new Class[]{Null.class, A08_Robot.class},
                new NullRobotProxyHandler(type));  // 只是获取名字SimpleName用的
    }

    public static void main(String[] args) {
        Stream.of(
                new A08_SnowRemovalRobot("SnowBee"),
                newNullRobot(A08_SnowRemovalRobot.class)
        ).peek(s -> System.out.println("---------"))
                .forEach(A08_Robot::test);
    }
}
