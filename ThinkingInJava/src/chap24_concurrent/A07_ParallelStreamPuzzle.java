package chap24_concurrent;

import onjava.Nap;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;

class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;

        public Integer get() {
            new Nap(0.01); // 使得资源读写更混乱.
            return current++;
        }
    }

    // 自己加的
    static class SafeIntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger(0);

        public Integer get() {
            new Nap(0.01); // Atomic并不能阻止混乱的发生.
            return current.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        List<Integer> x =
                Stream.generate(new IntGenerator())
                        .limit(10)
                        .parallel() // sth like[1, 3, 4, 6, 8, 0, 2, 4, 5, 7]
                        .collect(Collectors.toList());
        System.out.println(x);

        List<Integer> y =
                Stream.generate(new SafeIntGenerator())
                        .limit(10)
                        .parallel()
                        .collect(Collectors.toList());
        System.out.println(y);


    }
}

public class A07_ParallelStreamPuzzle {
}
