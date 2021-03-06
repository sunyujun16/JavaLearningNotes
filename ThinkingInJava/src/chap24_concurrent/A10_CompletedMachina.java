package chap24_concurrent;

import java.util.concurrent.*;

class CompletedMachina {
    public static void main(String[] args) {
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0));

        // 只是包装了一下, 啥也没干
        try {
            Machina m = cf.get(); // Doesn't block
        } catch (InterruptedException |
                ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

public class A10_CompletedMachina {
}
