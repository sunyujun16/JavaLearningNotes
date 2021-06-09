package chap20_generics;

import java.util.stream.*;

class BasicSupplierDemo {
    public static void main(String[] args) {
        Stream.generate(
                BasicSupplier.create(CountedObject.class)) // 后者构造器必须是public
                .limit(5)
                .forEach(System.out::println);
    }
}

public class A03_BasicSupplierDemo {
}
