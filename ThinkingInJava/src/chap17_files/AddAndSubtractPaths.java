package chap17_files;

import static org.junit.Assert.*;

import java.nio.file.*;
import java.io.IOException;

public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..")
            .toAbsolutePath()
            .normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute())
            System.out.println("(" + id + ")r " +
                    base.relativize(result));
            // 移除了根路经, resolve的路径也丢失.
        else
            System.out.println("(" + id + ") " + result + "  " +
                    "  --not absolute--");

        try {
            System.out.println("RealPath: "
                    + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);

        Path p = Paths.get("ThinkingInJava/src/chap17_files/" +
                "AddAndSubtractPaths.java")
                .toAbsolutePath();
        show(1, p);

        Path convoluted = p.getParent().getParent()
                .resolve("strings")
                .resolve("..") // 这一步和strings在relativize()时相互抵消了.
                .resolve(p.getParent().getFileName());
        System.out.println("\n" + convoluted + "\n");
        show(2, convoluted);
        show(3, convoluted.normalize()); // 还原?
        // 文档注释解释为: Returns a path that is
        // this path with redundant name elements eliminated.

        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());

        Path p3 = Paths.get(".").toAbsolutePath();
        System.out.println("p3: " + p3);

        Path p4 = p3.resolve(p2);
        show(7, p4);
        show(8, p4.normalize());

        // </home/sun/IdeaProjects/JavaLearningNotes>
        Path p5 = Paths.get("").toAbsolutePath();
        show(9, p5);
        show(10, p5.resolveSibling("try_cracking"));
        show(11, Paths.get("nonexistent"));

        // </home/sun/IdeaProjects/JavaLearningNotes/.>
        Path p6 = Paths.get(".").toAbsolutePath();
        show(12, p6);
        show(13, p6.resolveSibling("try_cracking"));

        assertEquals(p5, p6); // Throws Exception.
    }
}
