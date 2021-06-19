package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

import onjava.Nap;

class Baked {
    static class Pan {
    }

    static Pan pan(Batter b) {
        new Nap(0.1);
        return new Pan();
    }

    static Baked heat(Pan p) {
        new Nap(0.1);
        return new Baked();
    }

    static CompletableFuture<Baked>
    bake(CompletableFuture<Batter> cfb) {
        return cfb
                .thenApplyAsync(Baked::pan)
                .thenApplyAsync(Baked::heat);
        // 严丝合缝的返回值和参数对应, 形成一个调用串
    }

    public static Stream<CompletableFuture<Baked>> batch() {
        CompletableFuture<Batter> batter = Batter.mix();
        return Stream.of(bake(batter), bake(batter),
                bake(batter), bake(batter));
    }
}

public class A10_Baked {
}
