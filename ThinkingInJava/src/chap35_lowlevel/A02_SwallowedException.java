package chap35_lowlevel;

import onjava.Nap;

import java.util.concurrent.*;

class SwallowedException {
    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        exec.submit(() -> { // 用execute异常会抛出, 但submit没反应.
            System.out.println(Thread.currentThread().getName());
            throw new RuntimeException(); // 扔到哪里去了呢?
        });
        new Nap(1);
        exec.shutdown(); // nothing happens.
    }
}

public class A02_SwallowedException {
}
