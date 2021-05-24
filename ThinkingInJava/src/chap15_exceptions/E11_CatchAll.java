package chap15_exceptions;

class MyExceptionE11 extends Exception{}

class MyExceptionE112 extends Exception{}

public class E11_CatchAll {
    private static void f() throws MyExceptionE112 {
//        try{
//            g();
//        } catch (MyExceptionE11 e){
//            throw new MyExceptionE112();
//        }

        try{
            g();
        } catch (MyExceptionE11 e){
            throw new RuntimeException(e);
        }
    }

    private static void g() throws MyExceptionE11{
        throw new MyExceptionE11();
    }

    public static void main(String[] args) {
        try {
            f();
        }catch (MyExceptionE112 e){
            e.printStackTrace(System.out);
        }
    }
}
