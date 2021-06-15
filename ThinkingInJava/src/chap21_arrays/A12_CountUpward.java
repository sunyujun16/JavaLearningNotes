package chap21_arrays;

import java.util.*;
import java.util.stream.*;

import static onjava.ArrayShow.*;

class CountUpward {
    static long[] fillCounted(int size) {
        return LongStream.iterate(0, i -> i + 1)
                .limit(size).toArray();
    }

    public static void main(String[] args) {
        long[] l1 = fillCounted(20); // No problem
        show(l1);

        // On my machine, this runs out of heap space:
        // Well, your machine sucks.
        long[] l2 = fillCounted(10_000_000);
    }
}

public class A12_CountUpward {
}
