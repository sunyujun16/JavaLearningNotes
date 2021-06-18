package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

import static chap24_concurrent.CompletableUtilities.*;

class DualCompletableOperations {
    static CompletableFuture<Workable> cfA, cfB;

    static void init() {
        cfA = Workable.make("A", 0.15);
        cfB = Workable.make("B", 0.10); // Always wins
//        new Nap(0.2);
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("*****************");
    }

    public static void main(String[] args) {
//        init();
//        init();
//        new Nap(0.5);
//        System.out.println("?????????????????");

        init(); // 内部延迟,所以下面那句直接先执行并等待着A或B的生成.
        voidr(cfA.runAfterEitherAsync(cfB, () ->
                System.out.println("runAfterEither")));
        join();

        init();
        voidr(cfA.runAfterBothAsync(cfB, () ->
                System.out.println("runAfterBoth")));
        join();

        // 在show之前, A没有执行?
        init();
        showr(cfA.applyToEitherAsync(cfB, w -> {
            System.out.println("applyToEither: " + w);
            return w;
        }));
        join();

        init();
        voidr(cfA.acceptEitherAsync(cfB, w -> {
            System.out.println("acceptEither: " + w);
        }));
        join();

        // then代表等着吧
        init();
        voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> {
            System.out.println("thenAcceptBoth: "
                    + w1 + ", " + w2);
        }));
        join();

        init();
        showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
            System.out.println("thenCombine: "
                    + w1 + ", " + w2);
            return w1;
        }));
        join();

        init();
        CompletableFuture<Workable>
                cfC = Workable.make("C", 0.08),
                cfD = Workable.make("D", 0.09);
        CompletableFuture.anyOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() ->
                        System.out.println("anyOf"));
        join();

        new Nap(1);

        init();
        cfC = Workable.make("C", 0.08);
        cfD = Workable.make("D", 0.09);
        CompletableFuture.allOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() ->
                        System.out.println("allOf")); // 没打出来阿,顺序也不对.
        join();
    }
}

public class A10_DualCompletableOperations {
}
