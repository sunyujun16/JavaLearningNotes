package chap15_exceptions;

class BaseException extends Exception {
}

class DerivedException extends BaseException {
}

// can not compile until java7.
public class A06_PreciseRethrow {
    void catcher() throws DerivedException {
        try {
            throw new DerivedException();
        } catch (BaseException e) {
            throw e;
        }
    }
}

