package chap15_exceptions;
// "Turning off" Checked exceptions

import java.io.*;

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException(); // 它属于后面的IOException的子类.
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (IOException | RuntimeException e) {
            // Adapt to unchecked:
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {
} // It's checked.

public class A13_TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();

        // You can call throwRuntimeException() without a try block, and let
        // RuntimeExceptions leave the method:
        wce.throwRuntimeException(3);

        // Or you can choose to catch exceptions:
        for (int i = 0; i < 4; i++)
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                System.out.println(
                        "SomeOtherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause(); // 还原到上一个异常
                } catch (FileNotFoundException e) {
                    System.out.println(
                            "FileNotFoundException: " + e);
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
    }
}


