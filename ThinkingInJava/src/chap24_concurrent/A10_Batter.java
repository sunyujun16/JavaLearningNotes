package chap24_concurrent;

import java.util.concurrent.*;

import onjava.Nap;
import onjava.Timer;

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
        // 众所周知, allOf不会等待, 但是有join,那么下面的Nap就没意义了啊...

//        new Nap(0.1); // Mixing time. 其实这个Nap只是个模拟现实的逻辑而已, 和
        // 上面的代码没有关系.
        
        return CompletableFuture.completedFuture(new Batter());
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        mix();
        System.out.println(timer.duration()); // 经过测试, mix()注释的理论正确.
    }
}

public class A10_Batter {
}
