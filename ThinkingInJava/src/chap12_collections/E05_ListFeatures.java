package chap12_collections;

import reflection.pets.*;
import java.util.*;

public class E05_ListFeatures {
    private static PetCreator pc = new PetCreator();

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Integer> ints = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++) {
            ints.add(rand.nextInt(10));
        }
        System.out.println("1: " + ints);

        ints.add(5); // Automatically resizes
        System.out.println("2: " + ints);
        System.out.println("3: " + ints.contains(5));
        ints.remove((Integer) 1); // Remove by object

        Integer p = ints.get(2);
        System.out.println(
                "4: " + p + " " + ints.indexOf(p));

        Integer cymric = 8;
        System.out.println("5: " + ints.indexOf(cymric));
        System.out.println("6: " + ints.remove(cymric));

        // Must be the exact object:
        System.out.println("7: " + ints.remove(p));
        System.out.println("8: " + ints);

        ints.add(3, 7); // Insert at an index
        System.out.println("9: " + ints);
        List<Integer> sub = ints.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + ints.containsAll(sub));

        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);

        // Order is not important in containsAll():
        System.out.println("11: " + ints.containsAll(sub));
        System.out.println("11: " + ints);

        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + ints.containsAll(sub));

        List<Integer> copy = new ArrayList<>(ints);
        sub = Arrays.asList(ints.get(1), ints.get(4));
        System.out.println("sub: " + sub);

        copy.retainAll(sub);
        System.out.println("13: " + copy);

        copy = new ArrayList<>(ints); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);

        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);

        copy.set(1, 100); // Replace an element
        System.out.println("16: " + copy);

        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + ints.isEmpty());

        ints.clear(); // Remove all elements
        System.out.println("19: " + ints);
        System.out.println("20: " + ints.isEmpty());
    }
}

