package chap24_concurrent;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.*;

import com.google.common.collect.Sets;

class IDChecker {
    public static final int SIZE = 100_000;

    static class MakeObjects implements Supplier<List<Integer>> {
        private Supplier<HasID> gen;

        MakeObjects(Supplier<HasID> gen) {
            this.gen = gen;
        }

        @Override
        public List<Integer> get() {
            return
                    Stream.generate(gen)
                            .limit(SIZE)
                            .map(HasID::getID)
                            .collect(Collectors.toList());
        }
    }

    public static void test(Supplier<HasID> gen) {
        CompletableFuture<List<Integer>>
                groupA = CompletableFuture
                .supplyAsync(new MakeObjects(gen)), // 生成很多Integer的List.
                groupB = CompletableFuture
                        .supplyAsync(new MakeObjects(gen)); // 同上
        groupA.thenAcceptBoth(groupB, (a, b) -> {
            System.out.println(
                    Sets.intersection(
                            Sets.newHashSet(a),
                            Sets.newHashSet(b)).size()); // 按理说,应该是0.
        }).join();
    }
}

public class A12_IDChecker {
}
