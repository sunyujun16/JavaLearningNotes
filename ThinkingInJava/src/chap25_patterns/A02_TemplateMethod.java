package chap25_patterns;

// Simple demonstration of Template Method

import java.util.stream.*;

abstract class ApplicationFramework {
    ApplicationFramework() {
        templateMethod();
    }

    abstract void customize1();

    abstract void customize2();

    // "private" means automatically "final":
    private void templateMethod() {
        IntStream.range(0, 5).forEach(
                n -> {
                    customize1(); // 我觉得这个方法是通过Class对象找到的.
                    customize2(); // 后期绑定复习一下.
                });
    }
}

// Create a new "application":
class MyApp extends ApplicationFramework {
    @Override
    void customize1() {
        System.out.print("Hello ");
    }

    @Override
    void customize2() {
        System.out.println("World!");
    }
}

class TemplateMethod {
    public static void main(String[] args) {
        new MyApp();
    }
}

public class A02_TemplateMethod {
}
