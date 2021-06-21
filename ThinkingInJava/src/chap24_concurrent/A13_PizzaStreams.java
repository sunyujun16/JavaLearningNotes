package chap24_concurrent;

import java.util.*;
import java.util.stream.*;

import onjava.Timer;

class PizzaStreams {
    static final int QUANTITY = 5;

    public static void main(String[] args) {
        Timer timer = new Timer();
        IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .parallel() // [1]
                .forEach(za -> {
                    while (!za.complete())
                        za.next();
                });
        System.out.println(timer.duration());
    }

    // 从结果来看更加确定我的线程之稀少了, 有一个pizza直到其他的都完成才获取线程, 好可怜.
}

public class A13_PizzaStreams {
}
