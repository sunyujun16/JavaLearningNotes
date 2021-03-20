package chap07_ReusingClasses;

class Father {
    private String s;

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
    }

    @Override
    void eat() {
        append(" son swallow.");
    }

    @Override
    void move() {
        append(" son run.");
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
    Grand(){
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

    void study() {
        append(" go to school.");
    }

    public static void main(String[] args) {
        Grand g1 = new Grand();
        g1.append(" grandTest");
        g1.eat();
        g1.move();
        g1.study();
        System.out.println(g1);
    }
}

public class E02_Inheritance01 {
    public static void main(String[] args) {
//        // 实例化, 我们可以清楚地发现, 父类的构造方法最先被调用, 然后依次向下.
//        Grand grand = new Grand();
//        System.out.println("----------------------------");

        /* 实际上, 这种使用方式, 等于通过子类的实例, 去间接操纵父类的实例(并不实际存在),
        * 从而操作子类不具备的(不能直接访问的)字段和方法. */
        Grand.main(args);
        System.out.println("----------------------------");

        Son.main(args);
        System.out.println("----------------------------");

        Father.main(args);

    }
}
