package chap14_Streams;

import java.nio.file.*;
import java.util.stream.*;

public class A02_FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public A02_FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1) // Skip the comment line at the beginning
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+"))
                        builder.add(w);
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void
    main(String[] args) throws Exception {
        new A02_FileToWordsBuilder(
                "./ThinkingInJava/src/chap14_Streams/A02_Cheese.txt")
                .stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}


