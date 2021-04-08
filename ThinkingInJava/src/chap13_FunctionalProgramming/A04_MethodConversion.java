package chap13_FunctionalProgramming;

import java.util.function.*;

class In1 {
}

class In2 {
}

public class A04_MethodConversion {
    static void accept(In1 i1, In2 i2) {
        System.out.println("accept()");
    }

    static void someOtherName(In1 i1, In2 i2) {
        System.out.println("someOtherName()");
    }

    public static void main(String[] args) {
        BiConsumer<In1, In2> bic;

        bic = A04_MethodConversion::accept;
        bic.accept(new In1(), new In2());

        bic = A04_MethodConversion::someOtherName;
        // bic.someOtherName(new In1(), new In2()); // Nope
        bic.accept(new In1(), new In2());
    }
}
