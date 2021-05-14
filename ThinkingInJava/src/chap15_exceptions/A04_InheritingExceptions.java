package chap15_exceptions;

class SimpleException extends Exception {
}

public class A04_InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println(
                "Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        A04_InheritingExceptions sed =
                new A04_InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

