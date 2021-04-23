package chap14_Streams;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.regex.Pattern;

public class A02_FileToWordsRegexp {
    private String all;

    public A02_FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1) // First (comment) line
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return Pattern
                .compile("[ .,?]+").splitAsStream(all);
    }

    public static void
    main(String[] args) throws Exception {
        A02_FileToWordsRegexp fw =
                new A02_FileToWordsRegexp(
                        "ThinkingInJava/src/chap14_Streams/A02_Cheese.txt");
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}


