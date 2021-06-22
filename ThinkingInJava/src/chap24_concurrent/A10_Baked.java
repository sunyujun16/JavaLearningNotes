package chap24_concurrent;

import java.sql.Time;
import java.util.concurrent.*;
import java.util.stream.*;

import onjava.Nap;
import onjava.Timer;

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
        Timer timer = new Timer();
        CompletableFuture<Batter> batter = Batter.mix(); // 0.2s
        System.out.println("-:-:- " + timer.duration()); // 这句竟然花费了0.4s
        return Stream.of(bake(batter), bake(batter),
                bake(batter), bake(batter));
        // 每个bake花费0.2s,那么这句用了多少? 在FrostedCake里差不多也是0.2 说明还是并发的.
        // 但是并发发生在batch内部.因为return语句本身并不是Async的.
        // 又错了. mix花费0.4s,说明return根本没消耗时间.
        // 对呀!Stream没有终止条件是不执行的.
    }

    public static void main(String[] args) {
        //试试就知道了, 答案: 一瞬间. 根本不等待返回值, 打印发现全是Not complete对象.
        CompletableFuture<Batter> batter = Batter.mix();

        Timer timer = new Timer();
        for (int i = 0; i < 20; i++) {
            Stream.of(bake(batter), bake(batter),
                    bake(batter), bake(batter))
                    .forEach(b -> {});
        }
        System.out.println(timer.duration());

        timer.resetTime();
        for (int i = 0; i < 1; i++) {
            System.out.println(bake(batter));
        }
        System.out.println(timer.duration());


        timer.resetTime();
        for (int i = 0; i < 20; i++) {
            Stream.of(bake(batter), bake(batter),
                    bake(batter), bake(batter).join())
                    .forEach(b -> {
                    }); // 4个join是:21581 ms 我草...什么鬼?
            // 为什么这里执行超级慢? 因为全部在主线程, 这里就计算出来了, 但是
            // 完全是因为join影响的.
            // 只加一个join是13.5s, 平均每个循环是0.7s左右, 但是肯定
            // 受之前的几块没执行完的影响了, 所以这里不想继续研究了.没意义.
            // 总之结论就是, 没有join的bake是立即返回的.剩下的就在线程里默默运行
        }
        System.out.println(timer.duration());

    }
}

public class A10_Baked {
}
