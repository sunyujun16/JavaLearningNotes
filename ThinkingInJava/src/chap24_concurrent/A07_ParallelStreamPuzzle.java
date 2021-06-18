package chap24_concurrent;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;

        public Integer get() {
            return current++;
        }
    }

    public static void main(String[] args) {
        List<Integer> x =
                Stream.generate(new IntGenerator())
                        .limit(10)
                        .parallel() // sth like[1, 3, 4, 6, 8, 0, 2, 4, 5, 7]
                        .collect(Collectors.toList());
        System.out.println(x);
    }
}

public class A07_ParallelStreamPuzzle {
}
