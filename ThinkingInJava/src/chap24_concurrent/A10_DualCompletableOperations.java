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
                cfC = Workable.make("C1", 0.08);
        CompletableFuture<Workable>
                cfD = Workable.make("D1", 0.09);
        CompletableFuture.anyOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() ->
                        System.out.println("anyOf"));
        join();

//        new Nap(1);

        init();
        cfC = Workable.make("C2", 0.08);
        cfD = Workable.make("D2", 0.09);
        CompletableFuture.allOf(cfA, cfB, cfC, cfD)
                .thenRunAsync(() ->
                        System.out.println("allOf"));
        // 没打出来阿,顺序也不对. 代码一样结果不同, 整不明白...等等!
        // 我怀疑是我的虚拟机线程不够用(4线程), 所以D1只能复用C1的线程.所以这里打印的D
        // 实际上是上一个片段的D1, 而此处的D2还要等着D1的线程空闲(算下来0.19s)太慢了,
        // 故由于主线程的退出没能执行, 从而导致allOf也没能执行.
        // 至于C2为什么在B后面, 是因为D1霸占了一个线程刚好快要执行完毕但没有, 导致C2也
        // 发生0.02秒的等待, 加上程序执行的一点时间, 刚好和B的0.1秒前后脚.
        // 那么根据这个思路我们在-----------分隔行的下面添加一点代码.
        join();

        // 给D2和allOf充分执行的时间, 才能看到他俩的结果.
        new Nap(1);
        System.out.println("-----------------------------");

        // 把CD的时间大幅减少, 避免等待线程导致的时间交错, 这次应该能正常运行了.
        init();
        CompletableFuture<Workable>
                cfE = Workable.make("E1", 0.01);
        CompletableFuture<Workable>
                cfF = Workable.make("F1", 0.03);
        CompletableFuture.anyOf(cfA, cfB, cfE, cfF)
                .thenRunAsync(() ->
                        System.out.println("anyOf"));
        join();


        init();
        cfE = Workable.make("E2", 0.01);
        cfF = Workable.make("F2", 0.03);
        CompletableFuture.allOf(cfA, cfB, cfE, cfF)
                .thenRunAsync(() ->
                        System.out.println("allOf"));
        join();
        // 正常执行了. 说明我的猜想很可能是正确的.
        // 想准确验证, 搬运到windows的更多线程环境下运行一下就好.
        // 但是我觉得, 在实际应用中一旦采用了多线程, 应该是不在乎线程的执行顺序的
        // 否则势必要添加不必要的等待, 不只麻烦, 多线程的意义也失去了.
    }
}

public class A10_DualCompletableOperations {
}
