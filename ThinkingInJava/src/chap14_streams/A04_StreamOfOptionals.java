package chap14_streams;

import java.util.*;

public class A04_StreamOfOptionals {
    public static void main(String[] args) {
        A04_Signal.stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("-----------");

        A04_Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}

