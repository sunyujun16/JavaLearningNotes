package chap19_typeinfo;

// Private inner classes can't hide from reflection

import chap19_typeinfo.interfacea.*;

class InnerA {
    private static class C implements A {
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
    }

    public static A makeA() {
        return new C();
    }
}

public class A09_InnerImplementation {
    public static void main(String[] args) throws Exception {
        A a = InnerA.makeA();
        a.f();
        System.out.println(a.getClass().getName());

        // Reflection still gets into the private class: 挡不住了是吧? 草.
        A09_HiddenImplementation.callHiddenMethod(a, "g");
        A09_HiddenImplementation.callHiddenMethod(a, "u");
        A09_HiddenImplementation.callHiddenMethod(a, "v");
        A09_HiddenImplementation.callHiddenMethod(a, "w");
    }
}