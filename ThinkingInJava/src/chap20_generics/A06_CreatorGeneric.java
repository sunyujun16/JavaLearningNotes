package chap20_generics;

abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X {
}

// <X> has to be explicit to support : new X().
class XCreator extends GenericWithCreate<X> {
    @Override
    X create() {
        return new X();
    }

    void f() {
        System.out.println(
                element.getClass().getSimpleName());
    }
}

class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}

public class A06_CreatorGeneric {
}
