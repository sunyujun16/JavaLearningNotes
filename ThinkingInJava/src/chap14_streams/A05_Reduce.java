package chap14_streams;

import java.util.*;
import java.util.stream.*;

class Frobnitz {
    int size;

    Frobnitz(int sz) {
        size = sz;
    }

    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }

    // Generator:
    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class A05_Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
//                .forEach(System.out::println);
//                .peek(s -> System.out.print("..."))
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)  // 最终结果只是一个Optional.
                .ifPresent(System.out::println);
        // 注意结果中的小陷阱, reduce的结果在虚拟机退出之后才打印到控制台. 导致结果间断输出
    }
}

