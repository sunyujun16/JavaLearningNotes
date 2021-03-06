package chap30_iostreams;

// {VisuallyInspectOutput}

import java.io.*;

public class FileOutputShortcut {
    static String file = "ThinkingInJava/src/chap30_iostreams/" +
            "FileOutputShortcut.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(BufferedInputFile.read(
                                "ThinkingInJava/src/" +
                                        "chap30_iostreams/" +
                                        "FileOutputShortcut.java")));

                // Here's the shortcut:
                PrintWriter out = new PrintWriter(file)
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(BufferedInputFile.read(file));
    }
}