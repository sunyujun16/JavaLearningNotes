package chap14_streams;

import java.util.stream.*;

public class A02_StreamOf {
    public static void main(String[] args) {
        Stream.of(
                new A02_Bubble(1), new A02_Bubble(2), new A02_Bubble(3))
                .forEach(System.out::println);

        Stream.of("It's ", "a ", "wonderful ",
                "day ", "for ", "pie!")
                .forEach(System.out::print);

        System.out.println();

        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);
    }
}

