package chap03_Object;

class StaticTest {
    static int i = 0;
}

public class E07_Incrementable {

    private static void increase() {
        StaticTest.i++;
    }

    public static void main(String[] args) {
        E07_Incrementable inc = new E07_Incrementable();
        E07_Incrementable.increase();
        increase();
        //noinspection AccessStaticViaInstance
        inc.increase();// unusual usage, static methods are usually accessed by classes directly.

        System.out.println("So, there're " + StaticTest.i+" ways to access static methods.");
    }

}
