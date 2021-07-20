package chap17_files;

import java.util.*;
import java.nio.file.*;

public class ListOfLines {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(
                Paths.get("ThinkingInJava/src/chap14_streams/" +
                        "A02_Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))  // 去掉注释行
                .map(line ->
                        line.substring(0, line.length() / 2))  // chop to half
                .forEach(System.out::println);
    }
}
