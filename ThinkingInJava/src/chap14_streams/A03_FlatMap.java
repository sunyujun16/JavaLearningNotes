package chap14_streams;

import java.util.stream.*;

public class A03_FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(
                        i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);
    }
}
