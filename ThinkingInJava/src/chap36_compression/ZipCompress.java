package chap36_compression;

// Uses Zip compression to compress any
// number of files given on the command line
// {java ZipCompress ThinkingInJava/src/chap36_compression/ZipCompress.java}
// {VisuallyInspectOutput}

import java.util.zip.*;
import java.io.*;
import java.util.*;

public class ZipCompress {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("no arg!!!");
            System.exit(0);
        }

        try (
                FileOutputStream f =
                        new FileOutputStream("ThinkingInJava/src/" +
                                "chap36_compression/test.zip");
                CheckedOutputStream csum =
                        new CheckedOutputStream(f, new Adler32());
                ZipOutputStream zos = new ZipOutputStream(csum);
                BufferedOutputStream out =
                        new BufferedOutputStream(zos)
        ) {
            zos.setComment("A test of Java Zipping");

            // No corresponding getComment(), though.
            for (String arg : args) {
                System.out.println("Writing file " + arg);
                try (
                        InputStream in = new BufferedInputStream(
                                new FileInputStream(arg))
                ) {
                    zos.putNextEntry(new ZipEntry(arg)); // 注释则抛出:
                    // java.util.zip.ZipException: no current ZIP entry
                    int c;
                    while ((c = in.read()) != -1)
                        out.write(c);
                }
                out.flush();
            }

            // Checksum valid only after the file is closed!
            System.out.println(
                    "Checksum: " + csum.getChecksum().getValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Now extract the files:
        System.out.println("Reading file");
        try (
                FileInputStream fi =
                        new FileInputStream("ThinkingInJava/src/" +
                                "chap36_compression/test.zip");
                CheckedInputStream csumi =
                        new CheckedInputStream(fi, new Adler32());
                ZipInputStream in2 = new ZipInputStream(csumi);
                BufferedInputStream bis =
                        new BufferedInputStream(in2)
        ) {
            ZipEntry ze;
            while ((ze = in2.getNextEntry()) != null) {
                System.out.println("Reading file " + ze);
                int x;
                while ((x = bis.read()) != -1)
                    System.out.write(x);
            }
            if (args.length == 1)
                System.out.println(
                        "Checksum: " + csumi.getChecksum().getValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Alternative way to open and read Zip files:
        try (
                ZipFile zf = new ZipFile("ThinkingInJava/src/" +
                        "chap36_compression/test.zip")
        ) {
            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze2 = (ZipEntry) e.nextElement();
                System.out.println("File: " + ze2);
                // ... and extract the data as before
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
