package chap09_Interface;

interface Cycle{
    void ride();
    boolean goOn();
    void getDistance();
    // 接口默认方法的应用
    default void getGirl(){
        System.out.println("You're a single dog, hahahaha...");
    }
}

interface CycleFactory{
    Cycle getCycle();
    void disposeCycle(); // 不该在工厂接口中, 应该放在类接口中.
}

class Unicycle implements Cycle{
    private int distance = 0;
    private static final int MAX = 3;

    @Override
    public void ride() {
        ++distance;
    }

    @Override
    public boolean goOn() {
        return distance <= MAX;
    }

    @Override
    public void getDistance() {
        System.out.println("Unicycle has gone steps for: " + distance);
    }
}

class UnicycleFactory implements CycleFactory{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }

    @Override
    public void disposeCycle() { }
}

class Bicycle implements Cycle{
    private String girlfriend;
    private int distance = 0;
    private static final int MAX = 5;

    Bicycle() {}

    Bicycle(String girlfriend) {
        this.girlfriend = girlfriend;
    }

    @Override
    public void ride() {
        ++distance;
    }

    @Override
    public boolean goOn() {
        return distance != MAX;  // 我猜 != 比 <= 运行起来会块一点点.
    }

    @Override
    public void getDistance() {
        System.out.println("Unicycle has gone steps for: " + distance);
    }

    @Override
    public void getGirl() {
        if(girlfriend == null) Cycle.super.getGirl(); //调用接口默认方法
        else System.out.println("My girl is: " + girlfriend);
    }
}

class BicycleFactory implements CycleFactory{
    private String s;

    BicycleFactory() {}

    BicycleFactory(String s) {
        this.s = s;
    }

    // 通过 由构造参数得来的 成员变量 来向 Bicycle的构造方法 传递参数. 可由switch控制.
    @Override
    public Cycle getCycle() {
        if (s == null) return new Bicycle();
        return new Bicycle(s);
    }

    @Override
    public void disposeCycle() { }
}

public class E18_SimpleFactory {
    private static void playCycle(CycleFactory cycleFactory){
        Cycle c = cycleFactory.getCycle();
        while (c.goOn()){
            c.ride();
        }
        c.getDistance();
        c.getGirl();
    }

    public static void main(String[] args) {
        playCycle(new UnicycleFactory());
        playCycle(new BicycleFactory());
        playCycle(new BicycleFactory("Liuyihan"));

        System.out.println("\nYou are gonna get there, come on young man!");
    }
}










