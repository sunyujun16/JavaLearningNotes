package chap24_concurrent;

import java.util.concurrent.*;
import java.util.stream.*;

import onjava.Nap;

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
        Baked.batch().forEach(baked -> baked
                .thenCombineAsync(Frosting.make(),
                        (cake, frosting) ->
                                new FrostedCake(cake, frosting))
                .thenAcceptAsync(System.out::println)
                .join());
        // 这里不关心线程资源的分配和等待问题, 因为执行顺序并不重要, 让系统按需分配线程
        // 就完了. 但是如果每个原材料都有不同的等待时间, 而且相差很大, 那么可能会出现
        // 第一个原材料被加到第二个蛋糕的情况吗? 让我们(我自己)来分析一下.
        // 首先batch流肯定是一次性返回的. 正常来讲, 异步的回调行为发生在join处,
        // 但是此处因为发生异步执行的代码返回值作为batch的参数值. 所以Stream.of()必须
        // 等待参数值全部返回, 才能进行下一步. 参数没有值是没法继续的.
        // 那么再往回看, bake()方法是异步执行的, 没啥说的.
        // 再往回看, 这就是关键之处了, mix方法内部的join和等待, 共同确保了每一个
        // ingredient都执行完毕才返回batter. 因为new Batter()和原材料的创建不相关
        // 所以, 如果不等, 那么这个mix调用栈直接退出, 原材料可能还没有创建完成.
        // 这下算是清楚了, shit...
    }
}

public class A10_FrostedCake {
}
