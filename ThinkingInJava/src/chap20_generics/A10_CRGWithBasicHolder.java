package chap20_generics;

class Subtype extends BasicHolder<Subtype> {
}

class CRGWithBasicHolder {
    public static void main(String[] args) {
        Subtype
                st1 = new Subtype(),
                st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}

public class A10_CRGWithBasicHolder {
}