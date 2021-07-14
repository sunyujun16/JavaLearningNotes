package chap15_exceptions;

class CheckItBei extends Exception{
    @Override
    public String getMessage() {
        return getClass().getSimpleName() + super.getMessage();
    }
}

class NeverCaught {
    static void f() {
        throw new RuntimeException("From f()"); // 不被检查的异常, 编译器不管.
    }

    static void g() {
        f();
    }

    static void checked() throws CheckItBei{
        throw new CheckItBei();
    }

    static void callChecked() throws CheckItBei{
        checked(); // 被检查的异常, 必须throws或try-catch.
    }

    public static void main(String[] args) {
        g();
    }
}

public class A07_NeverCaught {
}
