package chap14_streams;

//import static java.util.stream.IntStream.*;
//
//public class A02_Repeat {
//    public static void repeat(int n, Runnable action) {
//        range(0, n).forEach(i -> action.run());
//    }
//}

import static onjava.Repeat.*;

public class A02_Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    // 如此简洁, fuck...
    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping!"));
        repeat(2, A02_Looping::hi);
    }
}
