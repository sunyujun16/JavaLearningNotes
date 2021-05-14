package chap14_streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.nio.file.*;

public class A02_RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    A02_RandomWords(String fname) throws IOException {
        List<String> lines =
                Files.readAllLines(Paths.get(fname));

        // Skip the first line:
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
    }

    @Override  // 原案例并没有显式指出.
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream()
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(new A02_RandomWords( // generate源码表明, 它的参数是一个Supplier,
                        // 这意味着,在更深层的实现中,必然要用到其get方法.
                        "./ThinkingInJava/src/chap14_streams/A02_Cheese.txt"))
                        // 这里无法识别dat后缀的文件. 报错NoSuchFileException
                        .limit(10)
                        .collect(Collectors.joining(" ")));
    }
}
