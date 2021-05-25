package chap15_exceptions;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class A11_StreamsAreAutoCloseable {
    public static void main(String[] args) throws IOException {
        try (
                Stream<String> in = Files.lines(
                        Paths.get("ThinkingInJava/src/chap15_exceptions/" +
                                "A11_StreamsAreAutoCloseable.java"));
                PrintWriter outfile = new PrintWriter("ThinkingInJava/src/chap15_exceptions/" +
                        "Results.txt"); // [1]
        ) {
            in.skip(5)
                    .limit(10)
                    .map(String::toLowerCase)
//                    .forEach(System.out::println); // console output.
                    .forEachOrdered(outfile::println); // output to file.
        } // [2]
    }
}
/*
[1] You can see another feature here: the resource specification
header can contain multiple definitions, separated by semicolons
(the final semicolon is accepted but optional). Each object defined
in the header will have its close() called at the end of the try
block.
[2] The try block for try-with-resources can stand alone,
without a catch or finally. Here, the IOException is
passed out through main() so it doesn’t have to be caught at the
end of the try.
*/