package chap20_generics;

import java.util.*;

class ByteSet {
    Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Set<Byte> mySet =
            new HashSet<>(Arrays.asList(possibles));
    // 但是自动装箱也不是啥都能装的:
    //     But you can't do this:
//     Set<Byte> mySet2 = new HashSet<>(
//     Arrays.<Byte>asList(1,2,3,4,5,6,7,8,9));

    // 这样跟最上面一样
    Set<Byte> mySet2 = new HashSet<>(
            Arrays.asList(new Byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

    public static void main(String[] args) {
        System.out.println(new ByteSet().mySet);
    }

}

public class A09_ByteSet {
}
