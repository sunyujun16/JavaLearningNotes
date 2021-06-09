package chap20_generics;

// {WillNotCompile}
class Manipulator<T> {
    private T obj;

    Manipulator(T x) {
        obj = x;
    }

    // Error: cannot find symbol: method f():
    public void manipulate() {
//        obj.f();
        // Error:(13, 12) java: 找不到符号
        //                 符号:   方法 f()
        //                 位置: 类型为T的变量 obj
        // 应该只能用反射来解决, 不知是否可行.
    }
}

class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator =
                new Manipulator<>(hf);
        manipulator.manipulate();
    }
}

public class A05_Manipulation {
}
