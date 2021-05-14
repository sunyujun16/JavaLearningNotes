package chap15_exceptions;

import java.util.logging.*;
import java.io.*;

class LoggingException extends Exception {
    private static Logger logger =
            Logger.getLogger("LoggingException");

    LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString()); // printing job is done here, not the pre clause.
        // severe: 严重的.
    }
}

public class A04_LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

        System.out.println("-------------------");

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

