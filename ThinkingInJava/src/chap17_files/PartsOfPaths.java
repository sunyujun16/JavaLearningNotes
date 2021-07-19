package chap17_files;

import java.nio.file.*;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p =
                Paths.get("ThinkingInJava/src/chap17_files/PartsOfPaths.java").toAbsolutePath();

        for (int i = 0; i < p.getNameCount(); i++)
            System.out.println(p.getName(i));

        System.out.println("ends with '.java': " +
                p.endsWith(".java"));

        for (Path pp : p) { // 遍历不包含根路径.
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp) + "\n");
        }

        System.out.println("\nStarts with " + p.getRoot() +
                " " + p.startsWith(p.getRoot()));
    }
}
