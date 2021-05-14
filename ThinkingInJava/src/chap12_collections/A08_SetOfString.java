package chap12_collections;

import java.util.*;

public class A08_SetOfString {
    /** @noinspection OverwrittenKey*/
    public static void main(String[] args) {
        Set<String> colors = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }
}
/* Output:
[Red, Yellow, Blue, Purple, Orange]
*/

