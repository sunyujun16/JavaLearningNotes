package chap14_Streams;

import java.util.*;

public class A01_Randoms {
    public static void main(String[] args) {
        new Random(47)
                .ints(5,20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(
                        s -> System.out.println(s));
//                        System.out::println);
    }
}
