package chap21_arrays;

// Returning arrays from methods

import java.util.*;

import static onjava.ArrayShow.*;

class IceCreamFlavors {
    private static SplittableRandom rand = new SplittableRandom(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];

        for (int i = 0; i < n; i++) {
            int t;
            do
                t = rand.nextInt(FLAVORS.length);
            while (picked[t]); // 利用boolean数组避免重复选择的小技巧.
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            show(flavorSet(3));
    }
}

public class A03_IceCreamFlavors {
}
