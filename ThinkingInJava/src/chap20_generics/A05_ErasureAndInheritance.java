package chap20_generics;

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

class Derived2 extends GenericBase {
} // No warning

// class Derived3 extends GenericBase<?> {
// }
// Strange error:
// no wildcard expected.
// unexpected type
// required: class or interface without bounds

class ErasureAndInheritance {
//    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj); // Warning here!

        // 简直是为所欲为...显然不写参数的话, 默认参数则为Object.
        String s = "constructor";
        d2.set(s);
        Integer n = 3;
        d2.set(n);

        // 同样的, 如果不指定参数, 当你获取的时候, 除了Object别无选择.
//         Integer n2 = d2.get(); // incompatible types
    }
}

public class A05_ErasureAndInheritance {
}
