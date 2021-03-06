package chap34_collectiontopics;

// Demonstrates Reference objects

import java.lang.ref.*;
import java.util.*;

class VeryBig {
    private static final int SIZE = 10_000;
    private long[] la = new long[SIZE];
    private String ident;

    VeryBig(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing " + ident);
    }
}

class References {
    private static ReferenceQueue<VeryBig> rq =
            new ReferenceQueue<>();

    public static void checkQueue(LinkedList<? extends Reference<VeryBig>> ll) {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null)
            System.out.println("In queue: " + inq.get());
        else System.out.println("完犊子");

        System.out.println(ll.getLast().get());
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 10;
        // Or, choose size via the command line:
        if (args.length > 0)
            size = Integer.valueOf(args[0]);

        LinkedList<SoftReference<VeryBig>> sa =
                new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<>(
                    new VeryBig("Soft " + i), rq));
            System.out.println(
                    "Just created: " + sa.getLast());
            checkQueue(sa);
        }

        LinkedList<WeakReference<VeryBig>> wa =
                new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<>(
                    new VeryBig("Weak " + i), rq));
            System.out.println(
                    "Just created: " + wa.getLast());
            checkQueue(wa);
        }

        SoftReference<VeryBig> s =
                new SoftReference<>(new VeryBig("Soft"));

        WeakReference<VeryBig> w =
                new WeakReference<>(new VeryBig("Weak"));

        System.gc();

        LinkedList<PhantomReference<VeryBig>> pa =
                new LinkedList<>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<>(
                    new VeryBig("Phantom " + i), rq));
            System.out.println(
                    "Just created: " + pa.getLast());
            checkQueue(pa);
        }
    }
}

public class A12_References {
}
