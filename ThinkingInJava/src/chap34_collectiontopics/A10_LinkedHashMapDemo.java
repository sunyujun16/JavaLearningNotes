package chap34_collectiontopics;

// What you can do with a LinkedHashMap

import java.util.*;

import onjava.*;

class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap =
                new LinkedHashMap<>(new CountMap(9));
        System.out.println(linkedMap);

        // Least-recently-used order:
        linkedMap =
                new LinkedHashMap<>(16,
                        0.75f, true);
        linkedMap.putAll(new CountMap(9));
        System.out.println(linkedMap);

        // get会使键值对移动到链表末尾. 这是LRU的"最近使用原则"决定的.
        for (int i = 0; i < 6; i++)
            linkedMap.get(i);
        System.out.println(linkedMap);

        linkedMap.get(0);
        System.out.println(linkedMap);
    }
}

public class A10_LinkedHashMapDemo {
}
