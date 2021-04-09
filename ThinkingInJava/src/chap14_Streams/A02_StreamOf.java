package chap14_Streams;

import java.util.stream.*;

public class A02_StreamOf {
    public static void main(String[] args) {
//        Stream.of(
//                new Bubble(1), new Bubble(2), new Bubble(3))
//                .forEach(System.out::println);

        Stream.of("It's ", "a ", "wonderful ",
                "day ", "for ", "pie!")
                .forEach(System.out::print);

        System.out.println();

        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);
    }
}

