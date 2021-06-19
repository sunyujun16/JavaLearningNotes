package chap24_concurrent;

import onjava.Nap;

import java.util.concurrent.*;

class StickHolder {
    private static class Chopstick {
    }

    private Chopstick stick = new Chopstick();

    private BlockingQueue<Chopstick> holder =
            new ArrayBlockingQueue<>(1);

    public StickHolder() {
        putDown();
    }

    public void pickUp() {
//        new Nap(0.1);
        try {
            holder.take(); // Blocks if unavailable
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void putDown() {
//        new Nap(0.1);
        try {
            holder.put(stick);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class A11_StickHolder {
}
