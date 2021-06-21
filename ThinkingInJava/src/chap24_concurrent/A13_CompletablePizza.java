package chap24_concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

import onjava.Timer;

class CompletablePizza {
    static final int QUANTITY = 5;

    public static CompletableFuture<Pizza> makeCF(Pizza za) {
        return CompletableFuture
                .completedFuture(za)
                .thenApplyAsync(Pizza::roll)
                .thenApplyAsync(Pizza::sauce)
                .thenApplyAsync(Pizza::cheese)
                .thenApplyAsync(Pizza::toppings)
                .thenApplyAsync(Pizza::bake)
                .thenApplyAsync(Pizza::slice)
                .thenApplyAsync(Pizza::box);
    }

    public static void show(CompletableFuture<Pizza> cf) {
        try {
            System.out.println(cf.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        List<CompletableFuture<Pizza>> pizzas =
                IntStream.range(0, QUANTITY)
                        .mapToObj(Pizza::new)
                        .map(CompletablePizza::makeCF)
                        .collect(Collectors.toList());
        System.out.println(timer.duration()); // 没有等待pizzas的返回值
        pizzas.forEach(CompletablePizza::show); // 这里得等, 因为要用.但是从结果
        // 发现, pizzas里的元素也是出来一个就show一个, 并没有等待pizza全部构建完成.
        System.out.println(timer.duration());
    }

    // 注意到一点: CompletableFuture不能使用主线程, 而Stream可以使用主线程.
}

public class A13_CompletablePizza {
}
