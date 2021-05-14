package chap13_functional_programming;

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class A03_UnboundMethodReference {
    public static void main(String[] args) {
        // MakeString ms = X::f; // [1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); // 同等效果
    }
}

