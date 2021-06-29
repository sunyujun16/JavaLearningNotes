package chap29_references;

// The Integer class cannot be changed

import java.util.*;
import java.util.stream.*;

class ImmutableInteger {
    public static void main(String[] args) {
        List<Integer> v = IntStream.range(0, 10)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(v);
        // But how do you change the int
        // inside the Integer?
    }
}

public class A04_ImmutableInteger {
}
