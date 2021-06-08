package chap20_generics;

class Automobile {

}

class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}

public class A01_Holder1 {}