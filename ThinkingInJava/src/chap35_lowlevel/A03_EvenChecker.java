package chap35_lowlevel;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import java.util.concurrent.*;

import onjava.Nap;
import onjava.TimedAbort;

class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
//            System.out.println(val + " " + Thread.currentThread().getName());
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel(); // Cancels all EvenCheckers
                // cancel()之后,由于cancel变量不是volatile,cancel的值
                // 有没有可能在CPU缓存中停留, 导致其他线程不能及时发现?
            }
        }
    }

    // Test any IntGenerator:
    public static void test(IntGenerator gp, int count) {
        List<CompletableFuture<Void>> checkers =
                IntStream.range(0, count)
                        .mapToObj(i -> new EvenChecker(gp, i))
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        checkers.forEach(CompletableFuture::join);
    }

    // Default value for count:
    public static void test(IntGenerator gp) {
        // 4秒之内, 主线程没有退出, 说明cancel大概率仍是true, 没找到呗.
        new TimedAbort(4, "No odd numbers discovered by now.");
        test(gp, 10);
    }

    public static void main(String[] args) {
        test(new IntGenerator(){
            private volatile AtomicInteger anInt =
                    new AtomicInteger(0);

            @Override
            public int next() {
//                if (anInt.get() == 3) return 2; // 让其他线程仍试图运行
//                if (anInt.get() > 100) anInt.set(1); // 引发cancel
                // 输出不只一行, 说明cancel生效之前有其他线程见缝插针了.
                // 总共就他妈俩线程干活, 有一个被TimeAbord占用, 主线程也不能用.
                anInt.getAndAdd(2);
                return anInt.get();
            }
        });
    }
}

public class A03_EvenChecker {
}
