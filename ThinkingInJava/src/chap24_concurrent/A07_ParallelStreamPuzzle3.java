package chap24_concurrent;

// {VisuallyInspectOutput}

import java.util.*;
import java.util.stream.*;

class ParallelStreamPuzzle3 {
    public static void main(String[] args) {
        List<Integer> x = IntStream.range(0, 100)
                .peek(e -> System.out.println(e + ": " +
                        Thread.currentThread().getName()))
                .limit(50)
                .parallel()
                .boxed()
                .collect(Collectors.toList());

        System.out.println(x);
    }
}

public class A07_ParallelStreamPuzzle3 {
}
