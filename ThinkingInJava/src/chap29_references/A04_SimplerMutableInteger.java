package chap29_references;

// A trivial wrapper class

import java.util.*;
import java.util.stream.*;

class IntValue2 {
    public int n;

    IntValue2(int n) {
        this.n = n;
    }
}

class SimplerMutableInteger {
    public static void main(String[] args) {
        List<IntValue2> v = IntStream.range(0, 10)
                .mapToObj(IntValue2::new)
                .collect(Collectors.toList());
        v.forEach(iv2 ->
                System.out.print(iv2.n + " "));

        System.out.println();

        v.forEach(iv2 -> iv2.n += 1);
        v.forEach(iv2 ->
                System.out.print(iv2.n + " "));
    }
}

public class A04_SimplerMutableInteger {
}
