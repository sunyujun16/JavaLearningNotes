// onjava/ProcessFiles.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package onjava;

import java.io.*;
import java.nio.file.*;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
//        System.out.println("我尼玛?????????????");
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
//        System.out.println("调用了 start");
        try {
            // 无参走这条线, 参数为当前根目录开始, IDEA默认为项目文件夹.
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        // Allow user to leave off extension:
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext; // arg 发生变化咯.
                        System.out.println("Into start() else::::");
                        strategy.process(
                                new File(arg).getCanonicalFile());
                    }
                    System.out.println("\n---------------------------" +
                            "------------------------------\n");
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        PathMatcher matcher = FileSystems.getDefault()
                // glob语法, 17章第五节.
                .getPathMatcher("glob:**/*.{" + ext + "}");
        System.out.println("Into processDirectoryTree() ::::");
        Files.walk(root.toPath())
                .filter(matcher::matches)
                .forEach(p -> strategy.process(p.toFile()));
    }
}
