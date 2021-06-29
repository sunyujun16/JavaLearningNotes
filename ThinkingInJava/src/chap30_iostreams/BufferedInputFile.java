package chap30_iostreams;

// {VisuallyInspectOutput}

import java.io.*;
import java.util.stream.*;

public class BufferedInputFile {
    public static String read(String filename) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename))) {
            return in.lines()
//                    .filter(line -> !line.startsWith("//"))
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.print(
                read("ThinkingInJava/src/chap30_iostreams/" +
                        "BufferedInputFile.java"));
    }
}


