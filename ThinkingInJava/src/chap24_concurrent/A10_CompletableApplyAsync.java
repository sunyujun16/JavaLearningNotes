package chap24_concurrent;

import java.util.concurrent.*;

import onjava.*;

class CompletableApplyAsync {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work);
//                        .thenApply(Machina::work)
//                        .thenApply(Machina::work)
//                        .thenApply(Machina::work)
//                        .thenApply(Machina::work);
        // Output:
//        Machina0: ONE
//        Machina0: TWO
//        Machina0: THREE
//        Machina0: complete
//        455
//        Machina0: complete
//        455

        System.out.println(timer.duration());

        // 打印出来的是 Machina0: complete.即最终保存的Machina对象.
        System.out.println(cf.join());

        System.out.println(timer.duration());
    }
}

public class A10_CompletableApplyAsync {
}
