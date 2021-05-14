package chap14_streams;

import java.util.stream.*;

public class A02_Bubbles {
    public static void main(String[] args) {
        Stream.generate(A02_Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}

