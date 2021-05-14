package chap14_streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class A02_Generator implements Supplier<String> {
    Random rand = new Random(47);
    char[] letters =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return "" + letters[rand.nextInt(letters.length)];
    }

    public static void main(String[] args) {
        String word = Stream.generate(new A02_Generator())
                .limit(30)
                .collect(Collectors.joining());
        System.out.println(word);
    }
}

