package chap14_Streams;

import java.util.stream.*;

public class A02_Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new A02_Fibonacci().numbers()
//                .skip(20) // Don't use the first 20
                .limit(10) // Then take 10 of them
                // 显然打印的是seed.
                .forEach(System.out::println);
    }
}

