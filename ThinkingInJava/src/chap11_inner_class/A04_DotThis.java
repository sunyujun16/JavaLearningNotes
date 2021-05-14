package chap11_inner_class;

// Accessing the outer-class object
public class A04_DotThis {
    void f() {
        System.out.println("A04_DotThis.f()");
    }

    public class Inner {
        public A04_DotThis outer() {
            return A04_DotThis.this;
// A plain "this" would be Inner's "this"
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        A04_DotThis dt = new A04_DotThis();
        A04_DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
