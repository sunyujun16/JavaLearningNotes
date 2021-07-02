package chap35_lowlevel;

// Synchronizing on another object

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

import onjava.Nap;

class DualSynch {
    ConcurrentLinkedQueue<String> trace =
            new ConcurrentLinkedQueue<>();

    public synchronized void f(boolean nap) {
        for (int i = 0; i < 5; i++) {
            trace.add(String.format("f() " + i));
            if (nap) new Nap(0.01);
        }
    }

    private Object syncObject = new Object();

    public void g(boolean nap) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                trace.add(String.format("g() " + i));
                if (nap) new Nap(0.01);
            }
        }
    }
}

class SyncOnObject {
    static void test(boolean fNap, boolean gNap) {
        DualSynch ds = new DualSynch();
        List<CompletableFuture<Void>> cfs =
                Arrays.stream(new Runnable[]{
                        () -> ds.f(fNap),
                        () -> ds.g(gNap)
                })
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        cfs.forEach(CompletableFuture::join);
        ds.trace.forEach(System.out::println);
    }

    public static void main(String[] args) {
        test(true, false);
        System.out.println("****");
        test(false, true);
    }
}

public class A06_SyncOnObject {
}
