package chap34_collectiontopics;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import onjava.*;

class Government implements Supplier<String> {
    static String[] foundation = (
            "strange women lying in ponds " +
                    "distributing swords is no basis " +
                    "for a system of government").split(" ");
    private int index;

    @Override
    public String get() {
        return foundation[index++];
    }
}

class SuppliersCollectionTest {
    public static void main(String[] args) {

        // Suppliers class from the Generics chapter:
        Set<String> set = Suppliers.create(
                LinkedHashSet::new, new Government(), 15);
        System.out.println(set);

        List<String> list = Suppliers.create(
                LinkedList::new, new Government(), 15);
        System.out.println(list);

        list = new ArrayList<>();
        Suppliers.fill(list, new Government(), 15);
        System.out.println(list);

        // Or we can use Streams:
        set = Arrays.stream(Government.foundation)
                .collect(Collectors.toSet());
        System.out.println(set); // No order.

        list = Arrays.stream(Government.foundation)
                .collect(Collectors.toList());
        System.out.println(list);

        list = Arrays.stream(Government.foundation)
                .collect(Collectors
                        .toCollection(LinkedList::new));
        System.out.println(list);

        set = Arrays.stream(Government.foundation)
                .collect(Collectors
                        .toCollection(LinkedHashSet::new));
        System.out.println(set);
    }
}

public class A05_SuppliersCollectionTest {
}
