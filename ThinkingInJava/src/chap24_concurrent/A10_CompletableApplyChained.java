package chap24_concurrent;

import java.util.concurrent.*;

import onjava.Timer;

class CompletableApplyChained {
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work);
        System.out.print(timer.duration());
        System.out.println(" ms");
    }
}

public class A10_CompletableApplyChained {
}
