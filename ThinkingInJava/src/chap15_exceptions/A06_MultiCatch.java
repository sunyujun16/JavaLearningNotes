package chap15_exceptions;

public class A06_MultiCatch {
    void x() throws Except1, Except2, Except3, Except4 {
    }

    void process() {
    }

    void f() {
        try {
            x();

        } catch (Except1 | Except2 | Except3 | Except4 e) {
            process();
        }
    }
}
