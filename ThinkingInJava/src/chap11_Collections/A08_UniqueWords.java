package chap11_Collections;

import java.util.*;
import java.nio.file.*;

public class A08_UniqueWords {
    public static void main(String[] args) throws Exception {

        List<String> lines = Files.readAllLines(
                Paths.get("/home/sun/IdeaProjects/JavaLearningNotes" +
                        "/ThinkingInJava/src/chap11_Collections/A08_SetOperations.java")
        );

//        Set<String> words = new TreeSet<>();
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (String line : lines)
            for (String word : line.split("\\W+"))
                if (word.trim().length() > 0) words.add(word);

        System.out.println(words);

    }
}

