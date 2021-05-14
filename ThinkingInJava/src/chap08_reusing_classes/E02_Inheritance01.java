package chap08_reusing_classes;

class Father {
    private String s;
    String j = "J is not private.";

    Father() {
        s = "Daddy.";
        System.out.println("Papa is ready !");
    }

    void append(String a) {
        s += a;
    }

    void eat() {
        append(" father eat.");
    }

    void move() {
        append(" father walk.");
    }

    void dispose(){
        System.out.println("Fa dispose.");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Father f1 = new Father();
        f1.append(" faTest");
        f1.eat();
        f1.move();
        System.out.println(f1);
    }
}

class Son extends Father {
    Son() {
        System.out.println("Son is ready!");
//        super();
//        Error:(40, 14) java: 对super的调用必须是构造器中的第一个语句
    }

    @Override
    void eat() {
        append(" son swallow.");
    }

    @Override
    void move() {
        append(" son run.");
    }

    @Override
    void dispose(){
        System.out.println("Son dispose.");
        super.dispose();
    }

    void getJ() {
        System.out.println(this.j + "says Son.");
    }

    void getJ(int n) {
        System.out.println(this.j + "says Son. param: " + n);
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        s1.append(" sonTest.");
        s1.eat();
        s1.move();
        System.out.println(s1);
    }
}

class Grand extends Son {
    Grand(int n) {
        System.out.println("Grand is ready!");
    }

    @Override
    void eat() {
        append(" grandson sip.");
    }

    @Override
    void move() {
        append(" grandson crawl.");
    }

    private void study() {
        append(" go to school.");
    }

    // 在子类重载父类的方法, 而非覆写.
    /** @noinspection SameParameterValue, WeakerAccess */
    void getJ(int n, String s) {
        System.out.println(this.j + "says Grand. param: " + n);
        super.getJ(n);
    }

    @Override
    void dispose(){
        System.out.println("Grand dispose.");
        super.dispose();
    }

    public static void main(String[] args) {
        Grand g1 = new Grand(8);
        g1.append(" grandTest");
        g1.eat();
        g1.move();
        g1.study();
        g1.getJ(8, "a");
        System.out.println(g1);
    }
}

class Baby extends Grand {
    Baby(int n) {
        super(n);
        System.out.println("Wa~~~~~~~, wa~~~~~~");
    }
}

class Baby2{
    public Baby2() {
    }

}

public class E02_Inheritance01 {
    public static void main(String[] args) {
//        // 实例化, 我们可以清楚地发现, 父类的构造方法最先被调用, 然后依次向下.
//        Grand grand = new Grand();
//        System.out.println("----------------------------");

        Baby baby = new Baby(8);
        System.out.println(baby);
        System.out.println("----------------------------");

        /* 实际上, 这种使用方式, 等于通过子类的实例, 去间接操纵父类的实例(被包在子类实例内部),
         * 从而操作子类不具备的(不能直接访问的)字段和方法. */
        Grand.main(args);
        System.out.println("----------------------------");

        Son.main(args);
        System.out.println("----------------------------");

        Father.main(args);
        System.out.println("----------------------------");

        baby.dispose();
    }
}
