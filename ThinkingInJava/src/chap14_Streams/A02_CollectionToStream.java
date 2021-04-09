package chap14_Streams;

import java.util.*;
import java.util.stream.*;

public class A02_CollectionToStream {
    public static void main(String[] args) {
        List<A02_Bubble> bubbles = Arrays.asList(
                new A02_Bubble(1), new A02_Bubble(2), new A02_Bubble(3));
        System.out.println(
                bubbles.stream()
                        .mapToInt(b -> b.i)
                        .sum());

        Set<String> w = new HashSet<>(Arrays.asList(
                "It's a wonderful day for pie!".split(" ")));
        w.stream()
                .map(x -> x + " ")
                .forEach(System.out::print);

        System.out.println();

        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }
}

