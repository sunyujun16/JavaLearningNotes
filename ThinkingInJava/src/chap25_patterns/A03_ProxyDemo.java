package chap25_patterns;

// Simple demonstration of the Proxy pattern
interface ProxyBase { // 这个名字叫AnyBase更好.
    void f();

    void g();

    void h();
}

class Proxy implements ProxyBase {
    private ProxyBase implementation;

    Proxy() {
        implementation = new Implementation();
    }

    // Pass method calls to the implementation:
    @Override
    public void f() {
        implementation.f();
    }

    @Override
    public void g() {
        implementation.g();
    }

    @Override
    public void h() {
        implementation.h();
    }
}

class Implementation implements ProxyBase {
    public void f() {
        System.out.println("Implementation.f()");
    }

    public void g() {
        System.out.println("Implementation.g()");
    }

    public void h() {
        System.out.println("Implementation.h()");
    }
}

class ProxyDemo {
    public static void main(String[] args) {
        Proxy p = new Proxy();
        p.f();
        p.g();
        p.h();
    }
}

public class A03_ProxyDemo {
}
