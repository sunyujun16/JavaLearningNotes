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
        System.out.println("panning");
        return new Pan();
    }

    static Baked heat(Pan p) {
        new Nap(0.1);
        System.out.println("heating");
        return new Baked();
    }

    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb) {
        return cfb
                .thenApplyAsync(Baked::pan)
                .thenApplyAsync(Baked::heat);
        // 严丝合缝的返回值和参数对应, 形成一个调用串
    }

    public static Stream<CompletableFuture<Baked>> batch() {
        Timer timer = new Timer();
        CompletableFuture<Batter> batter = Batter.mix(); // 0.2s?
        System.out.println("-:-:- " + timer.duration()); // 竟然花费了0.4s
        return Stream.<CompletableFuture<Baked>>of(bake(batter),
                bake(batter), bake(batter), bake(batter));
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
                    .forEach(b -> {
                        // 注释掉之后, 发现根本就不执行bake(), 编译器的优化吧应该是.
//                        try {
//                            System.out.print(b.get());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
                    });
        }
        System.out.println("\n"+timer.duration() + "---------------");

        timer.resetTime();
        for (int i = 0; i < 2; i++) {
            System.out.println(bake(batter)); // Not Complete全是.
        }
        System.out.println(timer.duration());


        timer.resetTime();
        for (int i = 0; i < 10; i++) {
            Stream.of(bake(batter), bake(batter).join())
                    .forEach(b -> {
                    }); // 4个join是:21581 ms 我草...什么鬼?
            // 总之结论就是, 没有join也没有被使用的bake是不执行的.
        }
        System.out.println(timer.duration());

    }
}

public class A10_Baked {
}
