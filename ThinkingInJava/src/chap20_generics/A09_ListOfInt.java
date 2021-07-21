package chap20_generics;

// Autoboxing compensates for the inability
// to use primitives in generics

import java.util.*;
import java.util.stream.*;

class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = IntStream.range(38, 48)
                .boxed() // Converts ints to Integers
                .collect(Collectors.toList());
        System.out.println(li);

        // Integer换成int,则编译不通过.因为数组不支持自动装箱.
        Integer[] aa = {1,2,0,4,5};
        li = new ArrayList<>( Arrays.asList(aa));
        System.out.println(li);

    }
}

public class A09_ListOfInt {
}
