package chap18_strings;

import java.util.*;
import java.util.stream.*;
import generics.coffee.*;

public class A03_ArrayListDisplay {
    public static void main(String[] args) {
        List<Coffee> coffees =
                Stream.generate(new CoffeeSupplier())
                        .limit(10)
                        .collect(Collectors.toList());
        System.out.println(coffees);
    }
}
