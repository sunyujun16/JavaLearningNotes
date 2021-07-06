package chap30_iostreams;

import onjava.Timer;

import java.io.*;

public class BasicFileOutput {
    static String file = "ThinkingInJava/src/chap30_iostreams/" +
            "BasicFileOutput.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(
                                BufferedInputFile.read(
                                        "ThinkingInJava/" +
                                                "src/chap30_iostreams/" +
                                                "BasicFileOutput.java")));
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(file)))
        ) {
            Timer timer = new Timer();
            in.lines().forEach(out::println);
            System.out.println(timer.duration());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 更快了, 马拉卡, 应该是体量太小导致缓冲区未充分利用.
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(
                                BufferedInputFile.read(
                                        "ThinkingInJava/" +
                                                "src/chap30_iostreams/" +
                                                "BasicFileOutput.java")));
                PrintWriter out = new PrintWriter(
                        new FileWriter(file))
        ) {
            Timer timer = new Timer();
            in.lines().forEach(out::println);
            System.out.println(timer.duration());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Show the stored file:
//        System.out.println(BufferedInputFile.read(file));
    }
}
