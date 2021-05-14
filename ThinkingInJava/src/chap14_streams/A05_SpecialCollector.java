package chap14_streams;

import java.util.*;

public class A05_SpecialCollector {
    public static void main(String[] args) throws Exception {
        ArrayList<String> words =
                A03_FileToWords.stream("ThinkingInJava/src/chap14_streams/A02_Cheese.txt")
                        .collect(ArrayList::new,  // 利用Supplier生成一个ArrayList
                                ArrayList::add,  // 利用Consumer接收上一步的结果和流中的元素,并整合. accept(ArrayList, String)
                                ArrayList::addAll); // 把每一步的整合结果添加到同一个ArrayList中. 还是Consumer
        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);
    }
}
