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

    public Frobnitz increase(){
        return new Frobnitz(++size);
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
                .peek(System.out::println) // 打印全部元素
//                .forEach(System.out::println);
//                .peek(s -> System.out.print("..."))
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0: fr1)  // 最终结果只是一个Optional.
                .ifPresent(s -> {
                    System.out.println(s + " --- result.");
                });
        // reduce的结果偶尔在虚拟机退出之后才打印到控制台. 导致结果间断输出
    }
}

