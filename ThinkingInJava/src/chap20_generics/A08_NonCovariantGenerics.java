package chap20_generics;

// {WillNotCompile}
import java.util.*;
class NonCovariantGenerics {
    // Compile Error: incompatible types:
//    List<Fruit> flist0 = new ArrayList<Apple>();
    // this is right yoo.
    List<? extends Fruit> flist = new ArrayList<Apple>();
}

public class A08_NonCovariantGenerics {
}
