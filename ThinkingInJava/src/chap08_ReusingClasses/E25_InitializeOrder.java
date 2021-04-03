package chap08_ReusingClasses;

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 =
            printInit("static Insect.x1 initialized");
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public static void fuck(){
        System.out.println("fuck.........");
    }
//    public static void main(String[] args) {
//        System.out.println("Beetle constructor");
//        Beetle b = new Beetle();
//    }
}

public class E25_InitializeOrder {
    private static int i = 3;
    public static int j;

    public E25_InitializeOrder() {
        System.out.println("Init E25.");
        j = 5;
    }

    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
        b.fuck(); // 不鼓励用实例来调用静态方法.
    }
}