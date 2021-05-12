package chap14_Streams;

import java.util.stream.*;

public class A03_FileToWordsTest {
    public static void main(String[] args) throws Exception {

        A03_FileToWords.stream("ThinkingInJava/src/chap14_Streams/A02_Cheese.txt")
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));

        System.out.println();

        A03_FileToWords.stream("ThinkingInJava/src/chap14_Streams/A02_Cheese.txt")
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}


