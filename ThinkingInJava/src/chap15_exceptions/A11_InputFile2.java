package chap15_exceptions;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class A11_InputFile2 {
    private String fname;

    public A11_InputFile2(String fname) {
        this.fname = fname;
    }

    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }

    public static void main(String[] args) throws IOException {
        new A11_InputFile2("ThinkingInJava/src/chap15_exceptions/A11_InputFile2.java")
                .getLines()
                .skip(17)
                .limit(1)
                .forEach(System.out::println);
    }
}

