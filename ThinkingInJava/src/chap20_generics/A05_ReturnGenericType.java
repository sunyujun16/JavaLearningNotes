package chap20_generics;

class ReturnGenericType<T extends HasF> {
    private T obj;
    ReturnGenericType(T x) { obj = x; }
    public T get() { return obj; }
}

public class A05_ReturnGenericType {

}
