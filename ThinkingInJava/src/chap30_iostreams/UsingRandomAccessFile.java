package chap30_iostreams;

import java.io.*;

public class UsingRandomAccessFile {
    static String file = "ThinkingInJava/src/" +
            "chap30_iostreams/rtest.dat";

    public static void display() {
        try (
                RandomAccessFile rf =
                        new RandomAccessFile(file, "r")
        ) {
            for (int i = 0; i < 7; i++)
                System.out.println(
                        "Value " + i + ": " + rf.readDouble());
            System.out.println(rf.readUTF());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try (
                RandomAccessFile rf =
                        new RandomAccessFile(file, "rw")
        ) {
            for (int i = 0; i < 7; i++)
                rf.writeDouble(i * 1.414);
            rf.writeUTF("The end of the file");
            rf.close();
            display();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (
                RandomAccessFile rf =
                        new RandomAccessFile(file, "rw")
        ) {
            rf.seek(5 * 8); // double是64位, 即:8个字节.
            rf.writeDouble(47.0001);
            rf.close();
            display();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
