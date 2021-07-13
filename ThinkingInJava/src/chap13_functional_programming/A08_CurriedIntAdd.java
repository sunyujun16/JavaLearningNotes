package chap13_functional_programming;

import java.util.function.*;

public class A08_CurriedIntAdd {
    public static void main(String[] args) {
        IntFunction<IntUnaryOperator>
                curriedIntAdd = a -> b -> a + b; // 这里的a其实是闭包变量

        IntUnaryOperator add4 = curriedIntAdd.apply(4);

        System.out.println(add4.applyAsInt(5));
    }
}

