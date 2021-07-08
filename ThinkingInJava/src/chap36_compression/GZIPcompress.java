package chap36_compression;

// {java GZIPcompress GZIPcompress.java}
import java.nio.file.Paths;
import java.util.zip.*;
import java.io.*;

public class GZIPcompress {
    private static final String testGZ = "ThinkingInJava/src/" +
            "chap36_compression/test.gz";


    public static void main(String[] args) {
//        System.out.println(Paths.get("."));
        if (args.length == 0) {
            System.out.println(
                    "Usage: \nGZIPcompress file\n" +
                            "\tUses GZIP compression to compress " +
                            "the file to test.gz");
            System.exit(1);
        }

        try (
                InputStream in = new BufferedInputStream(
                        new FileInputStream(args[0]));
                BufferedOutputStream out =
                        new BufferedOutputStream(
                                new GZIPOutputStream(
                                        new FileOutputStream(testGZ)))
        ) {
            System.out.println("Writing file");
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Reading file");
        try (
                BufferedReader in2 = new BufferedReader(
                        new InputStreamReader(new GZIPInputStream(
                                new FileInputStream(testGZ))))
        ) {
            in2.lines().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
