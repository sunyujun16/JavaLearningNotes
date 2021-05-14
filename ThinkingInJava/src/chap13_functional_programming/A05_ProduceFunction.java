package chap13_functional_programming;

import java.util.function.*;

interface FuncSS extends Function<String, String> {
} // [1]

public class A05_ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase(); // [2]
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
