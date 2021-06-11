package chap20_generics;

class SelfBoundingMethods {
    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }

    public static void main(String[] args) {
        A a = f(new A());
        // you should've known why this is forbidden.
//        D d = f(new D());
    }
}

public class A10_SelfBoundingMethods {
}
