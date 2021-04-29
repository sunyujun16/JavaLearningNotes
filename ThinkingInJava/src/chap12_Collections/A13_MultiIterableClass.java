package chap12_Collections;

// Adding several Adapter Methods

import java.util.*;

public class A13_MultiIterableClass extends A13_IterableClass {
    public Iterable<String> reversed() {
        return () -> new Iterator<>() {
            int current = words.length - 1;

            public boolean hasNext() {
                return current > -1;
            }

            public String next() {
                return words[current--];
            }
        };
    }

    public Iterable<String> randomized() {
        return () -> {
            List<String> shuffled =
                    new ArrayList<>(Arrays.asList(words));
            Collections.shuffle(shuffled, new Random(47));
            return shuffled.iterator();
        };
    }

    public static void main(String[] args) {
        A13_MultiIterableClass mic = new A13_MultiIterableClass();

        for (String s : mic.reversed())
            System.out.print(s + " ");
        System.out.println();

        for (String s : mic.randomized())
            System.out.print(s + " ");
        System.out.println();

        for (String s : mic)
            System.out.print(s + " ");
    }
}

