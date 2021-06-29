package chap30_iostreams;

import java.io.*;

public class FormattedMemoryInput {
    public static void main(String[] args) {
        try (
                DataInputStream in = new DataInputStream(
                        new ByteArrayInputStream(
                                BufferedInputFile.read(
                                        "ThinkingInJava/" +
                                                "src/chap30_iostreams/" +
                                                "FormattedMemoryInput.java")
                                        .getBytes()))
        ) {
            while (true)
                System.out.write((char) in.readByte());
        } catch (EOFException e) {
            System.out.println("\nEnd of stream 溜了溜了溜了.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
