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

        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int sum = 0;
        int num = 0;

        for (String line : lines)
            for (String word : line.split("\\W+")) {

                List<Character> chars = new ArrayList<>();
                for (Character c : vowels) {
                    for (Character w : word.toCharArray()) {
                        if (c == w) num++;
                    }
                }
                sum += num;
                System.out.println("word: " + word + " with " + num + " vowels");
                num = 0;

                if (word.trim().length() > 0) words.add(word);
            }

        System.out.println("Total vowels: " + sum);
        System.out.println(words);

    }
}

