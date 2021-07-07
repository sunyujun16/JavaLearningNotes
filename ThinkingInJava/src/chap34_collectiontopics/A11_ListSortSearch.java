package chap34_collectiontopics;

// Sorting/searching Lists with Collections utilities

import java.util.*;

class ListSortSearch {
    public static void main(String[] args) {
        List<String> list =
                new ArrayList<>(Utilities.list);

        list.addAll(Utilities.list);
        System.out.println(list);

        Collections.shuffle(list, new Random(47));
        System.out.println("Shuffled: \n" + list);

        // Use ListIterator to trim off last elements:
        ListIterator<String> it = list.listIterator(10);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println("Trimmed: \n" + list);

        Collections.sort(list);
        System.out.println("Sorted: \n" + list);

        String key = list.get(7);
        int index = Collections.binarySearch(list, key);
        System.out.println(
                "Location of " + key + " is " + index +
                        ", list.get(" + index + ") = " +
                        list.get(index));

        Collections.sort(list,
                String.CASE_INSENSITIVE_ORDER);
        System.out.println(
                "Case-insensitive sorted: \n" + list);

        key = list.get(7);
        index = Collections.binarySearch(list, key,
                String.CASE_INSENSITIVE_ORDER);
        System.out.println(
                "Location of " + key + " is " + index +
                        ", list.get(" + index + ") = " +
                        list.get(index));
    }
}

public class A11_ListSortSearch {
}
