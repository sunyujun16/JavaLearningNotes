package chap13_functional_programming;

import java.util.function.*;

class I {
    @Override
    public String toString() {
        return "I";
    }
}

class XX {
    public O toO(){
        return new O();
    }

    @Override
    public String toString() {
        return "X";
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}

public class A05_TransformFunction {
    // transform用来返回一个方法. 该方法是andThen()的返回值.
    // 理解源码的关键在于返回值类型.
    static Function<I, O> transform(Function<I, XX> in) {
        return in.andThen(xx -> {
            System.out.println(xx);
            return xx.toO();
        });
    }

    public static void main(String[] args) {
        Function<I, O> f2 = transform(i -> {
            System.out.println(i);
            return new XX();
        });

        O o = f2.apply(new I()); // 可以看到传给transform的in和andThen都执行了.

        // JAVA的这种通过lambda展示的高阶函数的写法, 比起Python和JS来还是晦涩,
        // 好在简化了很多函数的定义和对其赋值的过程. 可能是我对lambda还不熟悉吧.
    }
}

