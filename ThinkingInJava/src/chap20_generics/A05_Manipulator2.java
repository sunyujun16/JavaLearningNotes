package chap20_generics;

class Manipulator2<T extends HasF> {
    private T obj;
    Manipulator2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
}

public class A05_Manipulator2 {
}
