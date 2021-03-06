package chap14_streams;

import java.util.*;

public class A05_SpecialCollector {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words =
                A03_FileToWords.stream("ThinkingInJava/src/" +
                        "chap14_streams/A02_Cheese.txt")
                        .collect(// 利用Supplier生成一个ArrayList
                                ArrayList::new,
                        // 利用BiConsumer接收上一步的结果和流中的元素,并整合为n个ArrayList.
                                ArrayList::add,
                        // 把每一步的整合的ArrayList添加到同一个ArrayList中. 还是BiConsumer
                                ArrayList::addAll);
        words.stream()
                .filter(s -> s.contains("he"))
                .forEach(System.out::println);
    }
}
