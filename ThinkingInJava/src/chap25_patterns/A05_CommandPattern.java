package chap25_patterns;

import java.util.*;

class CommandPattern {
    public static void main(String[] args) {
        List<Runnable> macro = Arrays.asList(
                () -> System.out.print("Hello "),
                () -> System.out.print("World! "),
                () -> System.out.println("I'm the command pattern!")
        );
        macro.forEach(Runnable::run);
    }
}

public class A05_CommandPattern {
}
