package chap24_concurrent;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;

class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;

        public Integer get() {
            return current++;
        }
    }

    static class SafeIntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger(0);

        public Integer get() {
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
