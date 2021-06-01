package chap15_exceptions;

public class A06_Rethrowing {
    public static void f() throws Exception {
        System.out.println(
                "originating the exception in f()...........");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println(
                    "Inside g(), e.printStackTrace()");
            for(StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
            System.out.println();
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println(
                    "Inside h(), e.printStackTrace()");
            for(StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
            System.out.println();
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            for(StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
            System.out.println();
        }


        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            for(StackTraceElement ste : e.getStackTrace())
                System.out.println(ste.getMethodName());
            System.out.println();
        }
    }
}
