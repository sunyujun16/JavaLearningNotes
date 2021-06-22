package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

import onjava.Nap;
import onjava.Timer;

final class Frosting {
    private Frosting() {
    }

    static CompletableFuture<Frosting> make() {
        new Nap(0.1);
        return CompletableFuture
                .completedFuture(new Frosting());
    }
}

class FrostedCake {
    public FrostedCake(Baked baked, Frosting frosting) {
        new Nap(0.1);
    }

    @Override
    public String toString() {
        return "FrostedCake";
    }

    public static void main(String[] args) {
        Timer t1 = new Timer();
        Baked.batch().forEach(baked -> baked
                .thenCombineAsync(Frosting.make(),
                        (cake, frosting) ->
                                new FrostedCake(cake, frosting))
                .thenAcceptAsync(System.out::println)
                .join());
        System.out.println(t1.duration());
        // 这里不关心线程资源的分配和等待问题, 因为执行顺序并不重要, 让系统按需分配线程
        // 就完了.

        Timer timer = new Timer();
        Baked.batch().forEach(b -> b.thenRunAsync(() ->
                System.out.println(b))
                .join()
        );//join后时间为808. 之前是404. 这说明: 只有join能让程序等待
        System.out.println(timer.duration());
    }
}

public class A10_FrostedCake {
}
