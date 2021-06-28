package chap29_references;

// The clone() operation works for only a few
// items in the standard Java library

import java.util.*;
import java.util.stream.*;

class Int {
    private int i;

    Int(int ii) {
        i = ii;
    }

    public void increment() {
        i++;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class CloneArrayList {
    public static void main(String[] args) {
        ArrayList<Int> v = IntStream.range(0, 10)
                .mapToObj(Int::new)
                .collect(Collectors
                        .toCollection(ArrayList::new));
        System.out.println("v: " + v);

        @SuppressWarnings("unchecked")
        ArrayList<Int> v2 = (ArrayList<Int>) v.clone();

        // Increment all v2's elements:
        v2.forEach(Int::increment);

        // See if it changed v's elements:
        System.out.println("v: " + v);
    }
}

public class A02_CloneArrayList {
}
