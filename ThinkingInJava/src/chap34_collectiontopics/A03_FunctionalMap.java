package chap34_collectiontopics;

// Functional operations on a Map

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

import static onjava.HTMLColors.*;

class FunctionalMap {
    public static void main(String[] args) {
        MAP.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(v -> v.startsWith("Dark"))
                .map(v -> v.replaceFirst("Dark", "Hot"))
                .forEach(System.out::println);
    }
}

public class A03_FunctionalMap {
}
