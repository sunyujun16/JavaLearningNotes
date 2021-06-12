package chap19_typeinfo;

import chap19_typeinfo.pets.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

@SuppressWarnings("unchecked")
class FactoryPetCreator extends PetCreator {
    public static final List<Supplier<? extends Pet>> ALL_TYPES =
            Arrays.asList(new Supplier[]{
                    Pet::new, Dog::new, Cat::new, Rodent::new,
                    Mutt::new, Pug::new, EgyptianMau::new,
                    Manx::new, Cymric::new, Rat::new,
                    Mouse::new, Hamster::new}
                    );
    public static final List<Class<? extends Pet>> CLS_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class));


    // Types for random creation: 通过两个下标, 只取出最具体的子类.
    private static final List<Supplier<? extends Pet>> TYPES =
            ALL_TYPES.subList(4, ALL_TYPES.size());

    @Override
    public List<Class<? extends Pet>> types() {
//        TYPES.stream()
//                .peek(Supplier::get)
//                .peek(s -> System.out.println(s))
////                .peek(ob -> {
////                    Class cl = ob.getClass();
////                    System.out.println(cl.getSimpleName());
////                })
//                .collect(Collectors.toList())
////                    .forEach(s -> System.out.println(s))
//                    ;
        Mutt mt = (Mutt) TYPES.get(0).get();
        System.out.println(mt);
        // 这意味着必须强制转型, 唔...但是方法引用没有对象作为依托,
        // 看起来不能保留class信息.放弃了.
        // 这推翻了我之前关于函数式编程实际上有隐形对象的猜想.

        return null;
    }

    public static void main(String[] args) {
//        System.out.println(TYPES);
        new FactoryPetCreator().types();
    }
}

public class E15 {
}
