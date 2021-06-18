package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

import static chap24_concurrent.CompletableUtilities.*;
//import static onjava.CompletableUtilities.*;

class CompletableOperations {
    static CompletableFuture<Integer> cfi(int i) {
        return
                CompletableFuture.completedFuture(
                        Integer.valueOf(i));
    }

    public static void main(String[] args) {
        showr(cfi(1)); // Basic test
        voidr(cfi(2).runAsync(() ->
                System.out.println("runAsync"))); //返回一个CF<void>作为参数
        voidr(cfi(3).runAsync(()-> System.out.println("FirstDoNth..."))
                .thenRunAsync(() ->
                System.out.println("thenRunAsync...")));
        voidr(CompletableFuture.runAsync(() ->
                System.out.println("runAsync is static")));

        showr(CompletableFuture.supplyAsync(() -> 99));

        // lambda的参数类型就是CF对象的泛型参数<T>.这里就是Integer.
        voidr(cfi(4).thenAcceptAsync(i ->
                System.out.println("thenAcceptAsync: " + i)));
        showr(cfi(5).thenApplyAsync(i -> i + 42)); // 47
        showr(cfi(6).thenComposeAsync(i -> cfi(i + 99))); // 105

        // 没有join, 所以回调被主线程给干掉了. 不过TM的电脑风扇咋转得起劲呢???
        // 如果用showr()包装起来, 那么回调就只在showr()内部实现, 主线程仍要等待.
        cfi(100).thenApplyAsync(i -> {
            new Nap(1);
            System.out.println("* This never happens? .......嘿嘿");
            return 666;
        });

        CompletableFuture<Integer> c = cfi(7);
        c.obtrudeValue(111); // 篡位
        showr(c); // 111
        showr(cfi(8).toCompletableFuture()); // 8
        /* 这特么是我见过最离谱的源码......哦, 转型是吧...
        * public CompletableFuture<T> toCompletableFuture() {
                return this;
          }
        */

        c = new CompletableFuture<>(); // 我很空虚.
        c.complete(9); // 哎我又充实了.
        showr(c);

        c = new CompletableFuture<>();

        // 这个被cancel()直接干掉了.
        c.thenApplyAsync(i -> {
            new Nap(1);
            System.out.println("* And this happens? .......吼吼");
            return 888;
        });

        c.cancel(true);
        System.out.println("cancelled: " + c.isCancelled());
        System.out.println("completed exceptionally: " +
                c.isCompletedExceptionally());
        System.out.println("done: " + c.isDone());

//        try {
//            System.out.println(c.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        System.out.println(c);

        c = new CompletableFuture<>();
        System.out.println(c.getNow(777));

        c = new CompletableFuture<>();
        c.thenApplyAsync(i -> i + 42)
                .thenApplyAsync(i -> i * 12); // 这里只会生成1个dependent.
        // 这时调用get()程序会永远硬直. 不知道内存会不会耗尽, 没试.
        System.out.println(c); // [Not completed, 1 dependents]

        System.out.println("dependents: " +
                c.getNumberOfDependents());

        c.thenApplyAsync(i -> i / 2);
        System.out.println("dependents: " +
                c.getNumberOfDependents());

        System.out.println("第一波到此一停");
        new Nap(1);
    }
}

public class A10_CompletableOperations {
}
