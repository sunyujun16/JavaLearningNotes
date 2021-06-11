package chap20_generics;

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {
}

class GenericsAndReturnTypes {
    void test(Getter g) {
        // 不需要重写方法也能返回子类型.very nb.
        Getter result = g.get();
        GenericGetter gg = g.get(); // Also the base type
    }

    // 甚至这样也可以哦.
    void test2(GenericGetter<Getter> g) {
        Getter result = g.get();
        GenericGetter gg = g.get(); // Also the base type
    }

}

public class A10_GenericsAndReturnTypes {
}
