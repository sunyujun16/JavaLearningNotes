package chap14_streams;

import java.util.*;

public class A03_SortedComparator {
    public static void
    main(String[] args) throws Exception {
        A03_FileToWords.stream("ThinkingInJava/src/chap14_streams/A02_Cheese.txt")
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
/* Output:
you what to the that sir leads in district And
*/


