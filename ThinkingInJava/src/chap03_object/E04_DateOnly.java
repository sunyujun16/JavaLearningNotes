package chap03_object;

public class E04_DateOnly {
    int i;
    double d;
    boolean bl;

    public void E04_DateOnly() {
    }

    public static void main(String[] args) {
        E04_DateOnly e = new E04_DateOnly();
        e.i = 1;
        e.bl = true;
        e.d = 2.0;
        System.out.println("i: " + e.i + "\n" + "bl: " + e.bl + "\n" + "d: " + e.d);
    }

}
