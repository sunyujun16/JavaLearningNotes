package chap13_FunctionalProgramming;

import java.util.function.*;

class I {
    @Override
    public String toString() {
        return "I";
    }
}

class O {
    @Override
    public String toString() {
        return "O";
    }
}

public class A05_TransformFunction {
    // transform用来返回一个方法. 该方法在原apply执行之后的基础上进行了延伸.
    static Function<I, O> transform(Function<I, O> in) {
        // 以下就是transform返回的方法, 即in.andThen的返回值.
        // 而被传入到andThen中的参数, 也是一个方法, 该方法就是我们要延伸出来的行为, 阅读源码可知: 它接收的
        // 参数实际上是原始apply()的返回值, 而原始apply的行为则取决于我们自定义的in的行为.
        // 综上所述, andThen()方法的功能是: 接收一个自定义的行为, 让这个行为紧接着原始的apply之后发生.
        // 而这个行为需要一个参数, 即默认的apply返回值. (在此例中即我们看到的o).
        return in.andThen(o -> {
            System.out.println(o);
            return o;
        });
    }

    public static void main(String[] args) {
        // 有了上面的解析, 显然, 此处传入transform的参数就是我们定义的in的行为, 准确来讲是原始apply的行为.
        // 它返回的new O()将被传入andThen的形参所展示的行为函数, 这个函数的行为是: 打印o, 并返回o.
        // 注意, 这些事件的核心都是围绕着in(Function的实例对象)展开的. 所以andThen才能在底层获取apply的
        // 返回值.    如果再深究下去, in和after(见源码)本质上都是某个实现了Function接口的类的
        // 对象, 但这个实现过程被JAVA隐藏了.
        Function<I, O> f2 = transform(i -> {
            System.out.println(i);
            return new O();
        });

        // f2的apply执行的则是刚刚被transform所赋予的方法.
        O o = f2.apply(new I());

        // JAVA的这种通过lambda展示的高阶函数的写法, 我觉得比起Python和JS来还是更晦涩一些,
        // 好在简化了很多函数标识符的定义和对其赋值的过程. 可能是我对lambda还不熟悉吧.
    }
}

