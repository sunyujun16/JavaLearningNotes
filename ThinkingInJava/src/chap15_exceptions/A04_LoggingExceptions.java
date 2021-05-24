package chap15_exceptions;

import java.util.logging.*;
import java.io.*;

class LoggingException extends Exception {
    private static Logger logger =
            Logger.getLogger("Logging...Exception");

    LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString()); // printing job is done here, not the pre clause.
        // severe /sɪˈvɪr/: 严重的.
    }
}

public class A04_LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

        System.out.println("-------------------"); // 这行偶尔会在上一行之前输出, 说明发生了并行执行.

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

