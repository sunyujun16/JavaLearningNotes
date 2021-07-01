package chap34_collectiontopics;

import java.util.*;

import onjava.HTMLColors;

class SetOrder {
    static String[] sets = {
            "java.util.HashSet",
            "java.util.TreeSet",
            "java.util.concurrent.ConcurrentSkipListSet",
            "java.util.LinkedHashSet",
            "java.util.concurrent.CopyOnWriteArraySet",
    };
    static final List<String> RLIST =
            new ArrayList<>(HTMLColors.LIST);

    static {
        Collections.reverse(RLIST);
    }

    public static void main(String[] args) throws Exception {
        for (String type : sets) {
            System.out.format("[-> %s <-]%n",
                    type.substring(type.lastIndexOf('.') + 1));

            @SuppressWarnings("unchecked")
            Set<String> set = (Set<String>)
                    Class.forName(type).getDeclaredConstructor()
                            .newInstance();
            set.addAll(RLIST);
            set.stream()
                    .limit(10)
                    .forEach(System.out::println);
        }
    }
}

public class A02_SetOrder {
}
