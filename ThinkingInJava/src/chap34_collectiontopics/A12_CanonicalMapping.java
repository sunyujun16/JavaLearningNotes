package chap34_collectiontopics;

import onjava.TimedAbort;

import java.util.*;

class Element {
    private String ident;

    Element(String id) {
        ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ident);
    }

    @Override
    public boolean equals(Object r) {
        return r instanceof Element &&
                Objects.equals(ident, ((Element) r).ident);
    }

    @Override
    protected void finalize() {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    Key(String id) {
        super(id);
    }
}

class Value extends Element {
    Value(String id) {
        super(id);
    }
}

class CanonicalMapping {
    public static void main(String[] args) {
        int size = 1000;

        // Or, choose size via the command line:
        if (args.length > 0)
            size = Integer.valueOf(args[0]);

        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map =
                new WeakHashMap<>();

        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0)
                keys[i] = k; // Save as "real" references
            map.put(k, v);
        }
        System.gc();
        TimedAbort ta = new TimedAbort(1);
        ta.restart();
        // 从输出中可以看见, 凡是3的倍数, 都没有被自动回收.
        // 并且所有Value也没有跟着回收.
    }
}

public class A12_CanonicalMapping {
}
