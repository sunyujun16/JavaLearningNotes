package chap11_Collections;

// Adding groups of elements to Collection objects

import java.util.*;

public class A02_AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts)); // only way, not good.

        // Runs significantly faster, but you can't
        // construct a Collection this way:
        Collections.addAll(collection, 11, 12, 13, 14, 15); // several ways, good.
        Collections.addAll(collection, moreInts);

        // Produces a list "backed by" an array:
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element

        // list.add(21); // Runtime error; the underlying
        // array cannot be resized.

        for (Integer e:collection) {
            System.out.println(e);
        }
        for (Integer e:list) {
            System.out.println(e);
        }
    }
}
