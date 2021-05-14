package chap13_functional_programming;

import java.util.function.*;

public class A08_CurryingAndPartials {
    // Uncurried:
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Curried function:
        Function<String, Function<String, String>> sum =
                a -> b -> a + b; // [1]
        System.out.println(uncurried("Hi ", "Ho"));

        Function<String, String>
                hi = sum.apply("Hi "); // [2]
        System.out.println(hi.apply("Ho"));

        // Partial application:
        Function<String, String> sumHi =
                sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}

