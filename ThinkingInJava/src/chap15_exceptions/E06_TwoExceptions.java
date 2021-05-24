package chap15_exceptions;

import java.io.*;
import java.util.logging.*;

class MyExceptionA extends Exception {
    private static Logger logger = Logger.getLogger("AAAA");

    public MyExceptionA() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }
}

class MyExceptionB extends Exception {
    private static Logger logger = Logger.getLogger("BBBB");
    private String message;

    void showMessage() {
        StringWriter sw = new StringWriter();
        printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }

    public MyExceptionB() {
//        showMessage();
    }

    public MyExceptionB(String message) {
        super(message);
        this.message = message;
//        showMessage();
    }

    @Override
    public String getMessage() {
        return "-- " + message + " --" + super.getMessage();
    }
}

public class E06_TwoExceptions {
    private static void f() throws Exception {
        System.out.println("F A is coming...");
        throw new MyExceptionA();
    }

    private static void g() throws MyExceptionB {
        System.out.println("G B is coming.");
        throw new MyExceptionB("Hello Moto");
    }

    public static void main(String[] args) {
        // f()和g()采用不同打印日志策略, 前者为自动, 后者则手动调用showMessage方法.
        try {
            f();
        } catch (Exception e) {
//            e.printStackTrace();
        }

        try {
            g();
        } catch (MyExceptionB e) {
            e.showMessage();
        }
    }
}
