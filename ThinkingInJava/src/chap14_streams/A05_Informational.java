package chap14_streams;

import java.util.stream.*;
import java.util.function.*;

public class A05_Informational {
    public static void
    main(String[] args) throws Exception {
        System.out.println(
                A03_FileToWords.stream("ThinkingInJava/src/chap14_streams/A02_Cheese.txt")
                        .count());
        System.out.println(
                A03_FileToWords.stream("ThinkingInJava/src/chap14_streams/A02_Cheese.txt")
                        .min(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));
        System.out.println(
                A03_FileToWords.stream("ThinkingInJava/src/chap14_streams/A02_Cheese.txt")
                        .max(String.CASE_INSENSITIVE_ORDER)
                        .orElse("NONE"));
    }
}


