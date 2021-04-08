package chap13_FunctionalProgramming;

import java.nio.charset.IllegalCharsetNameException;
import java.util.*;
import java.util.function.*;

public class A06_Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        A06_Closure8 c7 = new A06_Closure8();

        List<Integer>
                l1 = c7.makeFun().get(),
                l2 = c7.makeFun().get(); // 注意get是supplier的方法, 不是list的方法, 差点混淆了.

        System.out.println(l1);
        System.out.println(l2);

        l1.add(42);
        l2.add(96);

        System.out.println(l1);
        System.out.println(l2);
    }
}

