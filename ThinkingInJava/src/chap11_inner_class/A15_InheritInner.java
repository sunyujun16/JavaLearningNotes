package chap11_inner_class;

// Inheriting an inner class
class WithInner {
    class Inner {
    }
}

public class A15_InheritInner extends WithInner.Inner {
    //- InheritInner() {} // Won't compile
    A15_InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        A15_InheritInner ii = new A15_InheritInner(wi);
    }
}

