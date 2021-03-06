package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

class CompletableExceptions {
    static CompletableFuture<Breakable>
    test(String id, int failcount) {
        return
                CompletableFuture.completedFuture(
                        new Breakable(id, failcount))
                        .thenApply(Breakable::work)
                        .thenApply(Breakable::work)
                        .thenApply(Breakable::work)
                        .thenApply(Breakable::work);
    }

    public static void main(String[] args) {
        // Got message, but, Exceptions don't appear...
        test("A", 1);
        test("B", 2);
        /* 直接看最后一行...
           我偷偷针对C设置了一个小延迟, 但并没有影响顺序执行, 这说明异步发生在test内部
           就是说异步只在其定义的作用域内部发生, 当程序跳出调用栈之前, 还是要等待其完成.
           还是说, 因为completedFuture的限制呢? 等复习的时候应该尝试一下.
           待续... 上面的结论已经推翻, 异步执行的线程在遇到join之前不会被主程序等待.
           -> 等会儿?! 异步个JB呀SB??? 代码都TM不是Async的! 你瞅瞅, 不复习能行?
        */
        test("C", 3);
        test("D", 4);
        test("E", 5);

//        new Nap(0.5);

        System.out.println("**********************");

        // ... until you try to fetch the value:
        try {
            test("F", 2).get(); // or join()
        } catch (Exception e) {
            System.out.println("抓到了: " + e.getMessage());
        }
        System.out.println("------------");

        // Test for exceptions: should be true
        System.out.println(
                test("G", 2).isCompletedExceptionally());
        System.out.println("------------");

        // Counts as "done": should be true
        System.out.println(test("H", 2).isDone());
        System.out.println("------------");

        // Force an exception:
        CompletableFuture<Integer> cfi =
                new CompletableFuture<>();
        System.out.println("done? " + cfi.isDone()); // should be false
        cfi.completeExceptionally(
                new RuntimeException("forced")); // 设置为完成并"埋伏"一个异常.
        System.out.println("------------");

        // java.lang.RuntimeException: forced
        try {
            cfi.get(); // 埋伏的Exception直到这里才触发.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class A10_CompletableExceptions {
}
