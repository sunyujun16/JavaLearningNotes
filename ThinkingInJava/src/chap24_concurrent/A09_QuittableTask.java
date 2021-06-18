package chap24_concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

import onjava.Nap;

class QuittableTask implements Runnable {
    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running =
            new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get()){ // [1]
            new Nap(0.1);
//            System.out.println(id + ": " + Thread.currentThread().getName());
        }
        System.out.print(id + " stop running.\n"); // [2]
    }
}

public class A09_QuittableTask {
}
