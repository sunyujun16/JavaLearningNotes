package chap14_streams;

import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class A05_TreeSetOfWords {
    public static void main(String[] args) throws Exception {
        Set<String> words2 =
                Files.lines(Paths.get("ThinkingInJava/src/" +
                        "chap14_streams/A05_TreeSetOfWords.java"))
                        .flatMap(line -> Arrays.stream(
                                line.split("\\W+")))
                        .filter(s -> !s.matches("\\d+")) // No num
                        .map(String::trim)
                        .filter(s -> s.length() > 2)
                        .limit(100)
                        .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}


