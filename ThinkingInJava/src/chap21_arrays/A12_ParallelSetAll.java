package chap21_arrays;

import java.util.*;

import onjava.*;

class ParallelSetAll {
    static final int SIZE = 10_000_000;

    static void intArray() {
        int[] ia = new int[SIZE];
        Arrays.setAll(ia, new Rand.Pint()::get);
        Arrays.parallelSetAll(ia, new Rand.Pint()::get);
    }

    static void longArray() {
        long[] la = new long[SIZE];
        Arrays.setAll(la, new Rand.Plong()::get);
        Arrays.parallelSetAll(la, new Rand.Plong()::get);
    }

    public static void main(String[] args) {
        intArray();
        longArray();
    }
}

public class A12_ParallelSetAll {
}
