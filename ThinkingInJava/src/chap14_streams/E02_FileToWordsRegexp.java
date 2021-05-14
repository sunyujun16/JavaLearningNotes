package chap14_streams;


import java.nio.file.*;
import java.util.stream.*;
import java.util.regex.Pattern;

public class E02_FileToWordsRegexp {
    private String all;

    private E02_FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1)
                .collect(Collectors.joining(" "));
    }

    private Stream<String> stream() {
        return Pattern.compile("[ ,.?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {
        E02_FileToWordsRegexp ef = new E02_FileToWordsRegexp(
                "ThinkingInJava/src/chap14_streams/A02_Cheese.txt");

        ef.stream()
                .limit(15)
                .map(w -> w + " ")
                .forEach(System.out::print);

        System.out.println("");

        ef.stream()
                .skip(5)
                .limit(10)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }

}
