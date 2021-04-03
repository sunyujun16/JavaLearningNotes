package chap12_Collections;


import java.util.HashSet;
import java.util.Random;

public class E02_SimpleCollections {
    public static void main(String[] args) {
        Random rand = new Random(47);
        HashSet<Integer> integers = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            integers.add(rand.nextInt(20));
        }

        for (Integer n : integers) {
            System.out.print(n + " ");
        }
    }
}
