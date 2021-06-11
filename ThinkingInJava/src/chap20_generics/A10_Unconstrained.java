package chap20_generics;

class Other {
}

class BasicOther extends BasicHolder<Other> {
}

class Unconstrained {
    public static void main(String[] args) {
        BasicOther b = new BasicOther();
        BasicOther b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
}
/* Output:
Other
*/

public class A10_Unconstrained {
}
