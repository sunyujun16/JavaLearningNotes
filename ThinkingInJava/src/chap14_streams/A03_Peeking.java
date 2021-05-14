package chap14_streams;

public class A03_Peeking {
    public static void main(String[] args) throws Exception {
        A03_FileToWords.stream("ThinkingInJava/src/chap14_streams/A02_Cheese.txt")
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
