package chap22_enums;

import java.util.*;
import java.util.function.*;

enum CartoonCharacter
        implements Supplier<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY,
    SILLY, BOUNCY, NUTTY, BOB;
    private Random rand =
            new Random(47);

    @Override
    public CartoonCharacter get() {
        return values()[rand.nextInt(values().length)];
    }
}

class EnumImplementation {
    public static <T> void printNext(Supplier<T> rg) {
        System.out.println(rg.get() + ", ");
    }

    public static void main(String[] args) {
// Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
            printNext(cc); // 这里每次都是调用BOB的get方法.
    }
}

public class A05_EnumImplementation {
}
