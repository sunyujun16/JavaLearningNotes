package chap15_exceptions;

class FCException extends Exception {
    FCException(){}

    FCException(String msg) {
        super(msg);
    }
}

class Disposeable {
    private static int i = 0;

    public Disposeable(int j) throws FCException{
        System.out.println(++i + " generating......");
        if (j < 6) throw new FCException(i + " failed !!!");
    }

    void dispose(){
        System.out.println("dispose successfully.");
        i--;
    }
}

public class E24_FailingConstructor {
    Disposeable dsp;

    public E24_FailingConstructor() throws FCException {
        try{
            dsp = new Disposeable(5);
            System.out.println("fist succeeded.");
        } catch (FCException e1) {
            System.out.println("first failed. starting second one.");
            try{
                dsp = new Disposeable(3);
                System.out.println("2nd succeeded.");
            } catch (FCException e2) {
                System.out.println("second failed. ending.");
                throw e2;
            }
        }
    }

    public E24_FailingConstructor(int i) throws FCException {
        if (i < 0) throw new FCException("嘎哈呢?");
    }

    void dispose(){
        dsp.dispose();
    }

    public static void main(String[] args) {
//        try{
//            E24_FailingConstructor e24 = new E24_FailingConstructor(-1);
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }

        try{
            E24_FailingConstructor e24 = new E24_FailingConstructor();
            try{
                //...
            } finally {
                e24.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
