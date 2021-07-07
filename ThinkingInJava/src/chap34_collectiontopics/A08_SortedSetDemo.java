package chap34_collectiontopics;

import java.util.*;

import static java.util.stream.Collectors.*;

class SortedSetDemo {
//    /** @noinspection Duplicates*/
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        SortedSet<String> sortedSet =
                Arrays.stream(
                        "one two three four five six seven eight"
                                .split(" "))
                        .collect(toCollection(TreeSet::new));
        System.out.println(sortedSet);

        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) low = it.next();
            if (i == 6) high = it.next();
            else it.next();
        }
        System.out.println(low);
        System.out.println(high);

        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}

public class A08_SortedSetDemo {
}
