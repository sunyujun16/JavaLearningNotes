package chap17_files;

import java.nio.file.*;

public class Find {
    public static void main(String[] args) throws Exception {
        Path test = Paths.get("ThinkingInJava/src/" +
                "chap17_files/test");
        Directories.refreshTestDir();
        Directories.populateTestDir();

        // Creating a *directory*, not a file, 虽然看起来像是文件.
        Files.createDirectory(test.resolve("dir.tmp"));
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{tmp,txt}");

        Files.walk(test)
                .filter(matcher::matches)
                .forEach(System.out::println);

        System.out.println("* * * * * * * * * * * * * * *");

        PathMatcher matcher2 = FileSystems.getDefault()
                .getPathMatcher("glob:*.tmp");

        Files.walk(test)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);

        System.out.println("***************");

        Files.walk(test) // Only look for files, in order to dump the dummy.
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }
}
