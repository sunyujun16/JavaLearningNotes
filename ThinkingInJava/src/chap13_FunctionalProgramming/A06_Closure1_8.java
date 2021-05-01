package chap13_FunctionalProgramming;

import java.util.*;
import java.util.function.*;

class Closure1 {
    static int i;
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }
}

class SharedStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }
}

class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }
}

class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
// Neither x++ nor i++ will work: 两个都白扯.
//        return () -> x++ + i++;
        return () -> x + i;
    }
}

class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}

class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
//        i++;
//        x++;
        return () -> x + i; // 如果上面两行不注释, 则发生"编译时错误".
    }
}

class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
//        return () -> x + i;  // 编译器报错: Variables in lambda expressions must be final or effectively final.
        final int iFinal = i;  // final关键字在这里很多余.
        final int xFinal = x;  // 因为这两个变量是 effectively final 的.
        return () -> xFinal + iFinal;
    }
}

class Closure7 {
    IntSupplier makeFun(int x) {
        Integer i = 0;
//        i = i + 1; // 这种小把戏骗不过编译器.
        return () -> x + i;
    }
}

public class A06_Closure1_8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        A06_Closure1_8 c7 = new A06_Closure1_8();

        List<Integer>
                l1 = c7.makeFun().get(), // get是Supplier接口中的方法.
                l2 = c7.makeFun().get();

        System.out.println(l1);
        System.out.println(l2);

        l1.add(42);
        l2.add(96);

        System.out.println(l1);
        System.out.println(l2);

//        String[] s = new String[0];
//        SharedStorage.main(s);
    }
}

class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
//        ai = new ArrayList<>(); // Reassignment
        return () -> ai;  // 若前一行注释打开, 则这里报错.
    }
}