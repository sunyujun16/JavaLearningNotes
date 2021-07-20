package chap17_files;

import java.util.*;
import java.nio.file.*;
import onjava.RmDir;

public class Directories {
    static Path test = Paths.get("ThinkingInJava/src/" +
            "chap17_files/test");
    static String sep =
            FileSystems.getDefault().getSeparator();
    static List<String> parts =
            Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);  // 向右滚动循环列表
        return Paths.get("ThinkingInJava/src/" +
                "chap17_files/test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if (Files.exists(test))
            RmDir.rmdir(test); // onjava包定义的方法. 底层调用walkFileTree(dir, 略), 并用匿名内部类重写第二个参数的方法
        if (!Files.exists(test))
            Files.createDirectory(test);
    }

    /**
     * this method creates a dir named test in your default relative path,
     * which is usually ./ .
     * then it make 4 dirs, for each one of which it generate a File.txt and
     * a .tmp file within. 擦, 写中文不行吗, 装什么b呢搁这?
     *
     * @return void
     *
     * @throws Exception
     *      if something happens, I don't know...
     */
    static void populateTestDir() throws Exception {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();

            if (!Files.exists(variant)) {
                Files.createDirectories(variant);  // 路径中不存在的父目录将被创建,源码注释已说明.
                Files.copy(Paths.get("ThinkingInJava/src/" +
                                "chap17_files/Directories.java"),
                        variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();  // 重生成test文件夹
        Files.createFile(test.resolve("Hello.txt"));  // test下创建文件Hello.txt. 此时目录结构仅有test和此文件.
        Path variant = makeVariant();  // 生成想要的文件路径(相对)的Path对象, test/bag/foo/bar/baz, 但是目录实际上还没有存在.

        // Throws exception (too many levels):
        try {
            System.out.println("variant: " + variant);  // variant: test/bag/foo/bar/baz
            Files.createDirectory(variant);  // 这个方法只能创建父目录已经存在的1层目录,源码注释已说明.
        } catch (Exception e) {
            System.out.println("Nope, that doesn't work.");
            System.out.println(e);  // java.nio.file.NoSuchFileException: test/bag/foo/bar/baz
        }
        populateTestDir();

        Path tempDir =
                Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(tempDir, "pre", ".non");
        Files.newDirectoryStream(test)
                .forEach(System.out::println);  // 打印test子目录和文件
        System.out.println("*********");
        Files.walk(test).forEach(System.out::println);  // 递归打印test子目录和文件,包括test本身.
    }
}
