package chap19_typeinfo;

// Sneaking around package hiding

import chap19_typeinfo.interfacea.*;
import chap19_typeinfo.packageaccess.*;

import java.lang.reflect.*;

public class A09_HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();  // c.f()
        System.out.println(a.getClass().getName()); // C

        // Compile error: cannot find symbol 'C':
        /* if(a instanceof C) {
        C c = (C)a;
        c.g();
        } */

        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");

        // And even less accessible methods!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName)
            throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);  // 偷取调用权限, 我擦类.
        g.invoke(a);
    }
}
