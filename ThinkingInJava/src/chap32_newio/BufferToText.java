package chap32_newio;

// Converting text to and from ByteBuffers

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;

public class BufferToText {
    private static final int BSIZE = 1024;
    private static String data2 = "ThinkingInJava/src/" +
            "chap32_newio/data2.txt";

    public static void main(String[] args) {
        try (
                FileChannel fc = new FileOutputStream(
                        data2).getChannel()
        ) {
            // 输出和输入都未指定字符集.
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        try (
                FileChannel fc = new FileInputStream(
                        data2).getChannel()
        ) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        // Doesn't work:
        System.out.println(buff.asCharBuffer()); // decode wrong.


        // Decode using this system's default Charset:
        buff.rewind();  // rewind.
        String encoding =
                System.getProperty("file.encoding");
        System.out.println("Decoded using " +
                encoding + ": "
                + Charset.forName(encoding).decode(buff));


        // Encode with something that prints:
        try (
                FileChannel fc = new FileOutputStream(
                        data2).getChannel()
        ) {
            fc.write(ByteBuffer.wrap(
                    "Some text".getBytes("UTF-16BE")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Now try reading again:
        buff.clear();
        try (
                FileChannel fc = new FileInputStream(
                        data2).getChannel()
        ) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer()); // 这回又可以了.


        // Use a CharBuffer to write through:
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        try (
                FileChannel fc = new FileOutputStream(
                        data2).getChannel()
        ) {
            fc.write(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read and display:
        buff.clear();
        try (
                FileChannel fc = new FileInputStream(
                        data2).getChannel()
        ) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
