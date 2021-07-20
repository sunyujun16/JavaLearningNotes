package chap17_files;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

import java.util.concurrent.*;

public class TreeWatcher {
    static int countTa = 0;

    static void watchDir(Path dir) {
        try {
            WatchService watcher =
                    FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_DELETE);
            Executors.newSingleThreadExecutor().submit(() -> {
                try {
                    WatchKey key = watcher.take();
                    for (WatchEvent evt : key.pollEvents()) {
                        System.out.println(
                                "evt.context(): " + evt.context() +
                                        "\nevt.count(): " + evt.count() +
                                        "\nevt.kind(): " + evt.kind());
                        System.out.println("-------" + countTa++ + "-------");
                        for (int i = 0; i < 100; i++) {
                            System.out.print(".");
                        }
                        System.out.println();
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted...");
                    return;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.walk(Paths.get("ThinkingInJava/src/" +
                "chap17_files/test"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);
                // 为什么检测不到Hello.txt, 因为根本就特么没生成...
                // 但是首次运行时打印了三个watch结果, 第二次打印了全部, 结果不稳定.
                // 这种朝三暮四的结果, 应该是多线程介入了.

        PathWatcher.delTxtFiles();
    }
}
