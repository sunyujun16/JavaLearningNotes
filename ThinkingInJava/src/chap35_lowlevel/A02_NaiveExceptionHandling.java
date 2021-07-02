package chap35_lowlevel;

// {ThrowsException}

import java.util.concurrent.*;

class NaiveExceptionHandling {
    public static void main(String[] args) {
        ExecutorService es =
                Executors.newCachedThreadPool();
        try {
            es.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
        // This statement will NOT execute!
            System.out.println("Exception was handled!");
        } finally {
            es.shutdown();
        }
    }
}

public class A02_NaiveExceptionHandling {
}
