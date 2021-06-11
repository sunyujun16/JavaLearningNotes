package chap20_generics;

class Base {}

class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    // Overridden method return type can vary:
    @Override
    Derived get();
}

class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
        Base d3 = d.get(); // 也没毛病
    }
}

public class A10_CovariantReturnTypes {
}
