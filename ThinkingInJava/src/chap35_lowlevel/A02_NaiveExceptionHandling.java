package chap35_lowlevel;

// {ThrowsException}

import java.util.concurrent.*;

class NaiveExceptionHandling {
//    public static void throwTMD(){
//        throw new RuntimeException("在这儿呢------------");
//    }


    public static void main(String[] args) {
//        throwTMD();

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
