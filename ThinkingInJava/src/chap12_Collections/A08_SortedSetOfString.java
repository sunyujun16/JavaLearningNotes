package chap12_Collections;

import java.util.*;

/** @noinspection OverwrittenKey*/
public class A08_SortedSetOfString {
    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Red");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }
}
/* Output:
[Blue, Orange, Purple, Red, Yellow]
*/
