package chap14_Streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class A04_Optionals {
    static void basics(Optional<String> optString) {
        if (optString.isPresent())
            System.out.println(optString.get());
        else
            System.out.println("Nothing inside!");
    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(
                optString.orElseGet(() -> "Generated"));
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(
                    () -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName,
                     Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", A04_Optionals::basics);
        test("ifPresent", A04_Optionals::ifPresent);
        test("orElse", A04_Optionals::orElse);
        test("orElseGet", A04_Optionals::orElseGet);
        test("orElseThrow", A04_Optionals::orElseThrow);
    }
}

