package chap24_concurrent;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.nio.file.*;

class ParallelStreamPuzzle2 {
    public static final Deque<String> trace =
            new ConcurrentLinkedDeque<>();

    static class IntGenerator implements Supplier<Integer> {
        private AtomicInteger current =
                new AtomicInteger();

        public Integer get() {
            trace.add(current.get() + ": " +
                    Thread.currentThread().getName());
            return current.getAndIncrement();
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> x =
                Stream.generate(new IntGenerator())
                        .limit(100)
                        .parallel() // 结果仍然不稳定
                        .collect(Collectors.toList());
        System.out.println(x);

        Files.write(Paths.get("ThinkingInJava/src/" +
                "chap24_concurrent/PSP2.txt"), trace);
    }
}

public class A07_ParallelStreamPuzzle2 {
}
