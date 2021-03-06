package chap20_generics;

// Generate a Fibonacci sequence

import java.util.function.*;
import java.util.stream.*;

class Fibonacci implements Supplier<Integer> {
    private int count = 0;

    @Override
    public Integer get() {
        return fib(count++,1,1);
    }

    // 线性递归
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    // 尾递归
    private int fib(int n, int a, int b){
        return n == 0 ? a :
                n == 1 ? b :
                        fib(n-1, b, a+b);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
                .limit(18)
                .map(n -> n + " ")
                .forEach(System.out::print);
    }
}

public class A02_Fibonacci {
}
