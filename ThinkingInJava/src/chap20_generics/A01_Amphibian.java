package chap20_generics;

public class A01_Amphibian {
}

class Amphibian {
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }
}