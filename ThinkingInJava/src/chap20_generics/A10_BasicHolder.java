package chap20_generics;

class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(
                element.getClass().getSimpleName());
    }
}

public class A10_BasicHolder {
}
