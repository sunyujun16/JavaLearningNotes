package chap14_streams;

import java.util.stream.*;

public class A02_Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")  // lambda替换Supplier的get方法. 无参, 有返回值.
                .limit(3)
                .forEach(System.out::println);
    }
}

