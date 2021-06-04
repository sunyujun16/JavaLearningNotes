package chap19_typeinfo;

// Sneaking around an interface

import chap19_typeinfo.interfacea.*;

class B implements A {
    @Override
    public void f() {
    }

    public void g() {
        System.out.println("BBBBBBBBB");
    }
}

public class A09_InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();

        // a.g(); // Compile error
        System.out.println(a.getClass().getSimpleName());
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}