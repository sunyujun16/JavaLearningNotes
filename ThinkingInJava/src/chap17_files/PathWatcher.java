package chap17_files;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

import java.util.concurrent.*;

public class PathWatcher {
    static Path test = Paths.get("ThinkingInJava/src/" +
            "chap17_files/test");

    static void delTxtFiles() {
        try {
            Files.walk(test)
                    .filter(f ->
                            f.toString().endsWith(".txt"))  // 注意toString的必要性
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        WatchService watcher =
                FileSystems.getDefault().newWatchService();
        test.register(watcher, ENTRY_DELETE);

        Executors.newSingleThreadScheduledExecutor()
                .schedule(
                        PathWatcher::delTxtFiles,
                        250, TimeUnit.MILLISECONDS);  // delay拖延了方法执行.

        WatchKey key = watcher.take();
        for (WatchEvent evt : key.pollEvents()) {
            System.out.println(
                    "evt.context(): " + evt.context() +
                            "\nevt.count(): " + evt.count() +
                            "\nevt.kind(): " + evt.kind());
            System.exit(0);
        }
    }
}
