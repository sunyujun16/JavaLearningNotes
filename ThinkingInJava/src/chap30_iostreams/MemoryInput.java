package chap30_iostreams;

// {VisuallyInspectOutput}

import java.io.*;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("ThinkingInJava" +
                        "/src/chap30_iostreams/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c); // 注意类型转换
    }
}
