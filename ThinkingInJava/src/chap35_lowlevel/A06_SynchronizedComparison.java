package chap35_lowlevel;

// Synchronizing blocks instead of entire methods
// speeds up access.

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

import onjava.Nap;

abstract class Guarded {
    AtomicLong callCount = new AtomicLong();

    public abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": " + callCount.get();
    }
}

class SynchronizedMethod extends Guarded {
    public synchronized void method() {
        new Nap(0.01);
        callCount.incrementAndGet();
    }
}

class CriticalSection extends Guarded {
    public void method() {
        new Nap(0.01);
        synchronized (this) {
            callCount.incrementAndGet();
        }
    }
}

class AnyObjectSyn extends Guarded {
    public void method() {
        new Nap(0.01);
        synchronized (new Object()) { // 可能是不对...不知道锁是否唯一.
            callCount.getAndIncrement();
        }
    }
}

class Caller implements Runnable {
    private Guarded g;

    Caller(Guarded g) {
        this.g = g;
    }

    private AtomicLong successfulCalls =
            new AtomicLong();
    private AtomicBoolean stop =
            new AtomicBoolean(false);

    @Override
    public void run() {
        new Timer().schedule(
                new TimerTask() {
                    public void run() {
                        stop.set(true);
                    }
                }, 2500);
        while (!stop.get()) {
            g.method();
            successfulCalls.getAndIncrement();
        }
        System.out.println(
                "-> " + successfulCalls.get());
    }
}

class SynchronizedComparison {
    static void test(Guarded g) {
        List<CompletableFuture<Void>> callers =
                Stream.of(
                        new Caller(g),
//                        new Caller(g), // 我只有三个可用线程
                        new Caller(g),
                        new Caller(g))
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        callers.forEach(CompletableFuture::join);
        System.out.println(g);
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        test(new CriticalSection());
        test(new SynchronizedMethod()); // 锁的分布极其不公平...
        test(new AnyObjectSyn());
    }
}

public class A06_SynchronizedComparison {
}
