package chap10_InnerClass;

// Creating an inner class directly using .new syntax
public class A05_DotNew {
    public class Inner {
    }

    public static void main(String[] args) {
        A05_DotNew dn = new A05_DotNew();
        A05_DotNew.Inner dni = dn.new Inner();
    }
}
