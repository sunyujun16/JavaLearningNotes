package chap13_FunctionalProgramming;

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class A03_RunnableMethodReference {
    public static void main(String[] args) {

        // Thread构造方法的参数接受一个Runnable对象.
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("lambda")
        ).start();

        new Thread(Go::go).start();
    }
}


