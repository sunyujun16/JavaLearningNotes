package chap30_iostreams;

// Testing for end of file
// {VisuallyInspectOutput}

import java.io.*;

public class TestEOF {
    public static void main(String[] args) {
        try (
                DataInputStream in = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(
                                        "ThinkingInJava/" +
                                        "src/chap30_iostreams/" +
                                        "TestEOF.java")))
        ) {
            while (in.available() != 0)
                System.out.write(in.readByte());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
