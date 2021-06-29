package chap29_references;

// A changeable wrapper class

import java.util.*;
import java.util.stream.*;

class IntValue {
    private int n;

    IntValue(int x) {
        n = x;
    }

    public int getValue() {
        return n;
    }

    public void setValue(int n) {
        this.n = n;
    }

    public void increment() {
        n++;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

class MutableInteger {
    public static void main(String[] args) {
        List<IntValue> v = IntStream.range(0, 10)
                .mapToObj(IntValue::new)
                .collect(Collectors.toList());
        System.out.println(v);

        v.forEach(IntValue::increment);
        System.out.println(v);
    }
}

public class A04_MutableInteger {
}
