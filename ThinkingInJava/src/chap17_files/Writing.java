package chap17_files;

import java.util.*;
import java.nio.file.*;

public class Writing {
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {

        // Write bytes to a file:
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Files.write(Paths.get("ThinkingInJava/src/chap17_files/"
                + "bytes.dat"), bytes);
        System.out.println("bytes.dat: " +
                Files.size(Paths.get("ThinkingInJava/src/" +
                        "chap17_files/bytes.dat")));

        // Write an iterable to a file:
        List<String> lines = Files.readAllLines(
                Paths.get("ThinkingInJava/src/chap14_streams/"
                        + "A02_Cheese.dat"));
        Files.write(Paths.get("ThinkingInJava/src/chap17_files/"
                + "Cheese.txt"), lines);
        System.out.println("Cheese.txt: " +
                Files.size(Paths.get("ThinkingInJava/src/" +
                        "chap17_files/Cheese.txt")));
    }
}
