package chap20_generics;

class Manipulator3 {
    private HasF obj;
    Manipulator3(HasF x) { obj = x; }
    public void manipulate() { obj.f(); }
}

public class A05_Manipulator3 {
}
