package chap17_files;

import java.nio.file.*;

public class ReadLineStream {
    public static void
    main(String[] args) throws Exception {
        Files.lines(Paths.get("ThinkingInJava/src/chap17_files/"
                + "PathInfo.java"))
                .skip(22)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
