package chap19_typeinfo;

// Anonymous inner classes can't hide from reflection

import chap19_typeinfo.interfacea.*;

class AnonymousA {
    public static A makeA() {
        return new A() {
            public void f() {
                System.out.println("public C.f()");
            }

            public void g() {
                System.out.println("public C.g()");
            }

            void u() {
                System.out.println("package C.u()");
            }

            protected void v() {
                System.out.println("protected C.v()");
            }

            private void w() {
                System.out.println("private C.w()");
            }
        };
    }
}

public class A09_AnonymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // Reflection still gets into the anonymous class: 反射牛逼...
        A09_HiddenImplementation.callHiddenMethod(a, "g");
        A09_HiddenImplementation.callHiddenMethod(a, "u");
        A09_HiddenImplementation.callHiddenMethod(a, "v");
        A09_HiddenImplementation.callHiddenMethod(a, "w");
    }
}
