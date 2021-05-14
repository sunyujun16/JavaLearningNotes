package chap14_streams;

import java.util.*;

class CreatingOptionals {
    static void test(String testName, Optional<String> opt) {
        System.out.println(" === " + testName + " === ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {
        test("empty", Optional.empty());

        test("of", Optional.of("Howdy"));
        try {
            test("of", Optional.of(null)); // 爆出空指针异常
        } catch (Exception e) {
            System.out.println(e);
        }

        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}

public class A04_CreatingOptionals {
}
