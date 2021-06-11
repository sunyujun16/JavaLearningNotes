package chap20_generics;

// 嵌套的内部只是为了一个目的: 保证子类去使用一个(可以操纵自己的)自绑定的自己的子类,
// 再通俗一点:它的泛型类型必须是子类,这个子类又必须是自限定的.
class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

class A extends SelfBounded<A> {}

class B extends SelfBounded<A> {} // Also OK

// 恩哼...nah
//class B2 extends SelfBounded<B>{}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

class D {}

// Can't do this:
// class E extends SelfBounded<D> {}
// Compile error:
// Type parameter D is not within its bound

// Alas, you can do this, so you cannot force the idiom:
class F extends SelfBounded {}

// 这个当然是不行的:
//class G extends SelfBounded<F>{}

class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();

        C c = new C();
        c = c.setAndGet(new C());
    }
}

public class A10_SelfBounding {
}
