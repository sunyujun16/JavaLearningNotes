package chap32_newio;

import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;

public class FileLocking {
    public static void main(String[] args) {
        try (
                FileOutputStream fos =
                        new FileOutputStream("ThinkingInJava/" +
                                "src/chap32_newio/file.txt");
                FileLock fl = fos.getChannel().tryLock()
        ) {
            if (fl != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(100);
                fl.release();
                System.out.println("Released Lock");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
