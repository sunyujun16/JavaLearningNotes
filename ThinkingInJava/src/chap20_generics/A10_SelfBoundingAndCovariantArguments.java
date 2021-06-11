package chap20_generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

interface AnotherSetter extends SelfBoundSetter<AnotherSetter>{

}

class SelfBoundingAndCovariantArguments {
    void testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2); // OK
        s2.set(s1); // OK
        sbs.set(s1); // OK
        sbs.set(s2); // OK
        sbs.set(new AnotherSetter(){
            @Override
            public void set(AnotherSetter arg) {
                System.out.println("hahahahahahaha");
            }
        }); // OK

//        - s1.set(sbs);
//        error: method set in interface SelfBoundSetter<T>cannot be
//        applied to given types;
//        s1.set(sbs);
//        ^
//        required: Setter
//        found: SelfBoundSetter
//        reason: argument mismatch;
//        SelfBoundSetter cannot be converted to Setter
//        where T is a type-variable:
//        T extends SelfBoundSetter<T> declared in
//        interface SelfBoundSetter
//        1 error
    }
}

public class A10_SelfBoundingAndCovariantArguments {
}
