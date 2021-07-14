package chap15_exceptions;

import java.util.logging.*;
import java.io.*;

class LoggingException extends Exception {
    private static Logger logger =
            Logger.getLogger("Logging...Exception");

    LoggingException() {
        StringWriter trace = new StringWriter(); // 建立trace
        printStackTrace(new PrintWriter(trace)); // 写入trace
        logger.severe(trace.toString()); // 打印trace
        // severe /sɪˈvɪr/: 严重的.
    }
}

public class A04_LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.out.println(Thread.currentThread().getName());
            System.err.println("Caught " + e);
        }

        System.out.println("-------------------");
        // 这行偶尔会在上一行之前输出, 说明发生了并行执行??? 然而并没有...

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

