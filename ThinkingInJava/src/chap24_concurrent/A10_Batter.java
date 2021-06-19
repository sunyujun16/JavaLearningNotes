package chap24_concurrent;

import java.util.concurrent.*;

import onjava.Nap;

class Batter {
    static class Eggs {
    }

    static class Milk {
    }

    static class Sugar {
    }

    static class Flour {
    }

    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    // wrap an ingredient. 0.1s delay.
    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture
                .completedFuture(ingredient)
                .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());
        CompletableFuture.allOf(eggs, milk, sugar, flour)
                .join();

//        new Nap(0.1); // Mixing time
        new Nap(0.2); // 我的4线程环境, 除了主线程只有3个, 所以多给一点时间去Mix.

        return CompletableFuture.completedFuture(new Batter());
    }
}

public class A10_Batter {
}
