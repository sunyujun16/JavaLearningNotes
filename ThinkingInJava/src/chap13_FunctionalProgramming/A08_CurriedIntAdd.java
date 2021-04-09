package chap13_FunctionalProgramming;

import java.util.function.*;

public class A08_CurriedIntAdd {
    public static void main(String[] args) {
        IntFunction<IntUnaryOperator>
                curriedIntAdd = a -> b -> a + b;

        IntUnaryOperator add4 = curriedIntAdd.apply(4);

        System.out.println(add4.applyAsInt(5));
    }
}

