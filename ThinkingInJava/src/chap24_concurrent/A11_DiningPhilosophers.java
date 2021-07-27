package chap24_concurrent;

import java.util.*;
import java.util.concurrent.*;

import onjava.Nap;

class DiningPhilosophers {
    private StickHolder[] sticks;
    private Philosopher[] philosophers;

    public DiningPhilosophers(int n) {
        sticks = new StickHolder[n];
        Arrays.setAll(sticks, i -> new StickHolder());
        // i是下标, 还得几遍能记住?!?!!!???

        philosophers = new Philosopher[n];

        Arrays.setAll(philosophers, i ->
                new Philosopher(i,
                        sticks[i], sticks[(i + 1) % n])); // [1]

        // Fix by reversing stick order for this one:
        // philosophers[1] = // [2]
        // new Philosopher(0, sticks[0], sticks[1]);
        Arrays.stream(philosophers)
                .forEach(CompletableFuture::runAsync); // [3]
    }

    public static void main(String[] args) {
        // Returns right away:
        new DiningPhilosophers(2); // [4] 改成2个比较容易上锁, 俩人抢得欢.

        // Keeps main() from exiting:
        new Nap(3, "Shutdown");
    }
}

public class A11_DiningPhilosophers {
}
