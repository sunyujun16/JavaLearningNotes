package chap20_generics;

import java.lang.reflect.*;
import java.util.*;

class Apply {
    public static <T, S extends Iterable<T>>
    void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq)
                f.invoke(t, args);
            // 自己写着玩儿的:
//            seq.forEach(ss -> {
//                try {
//                    f.invoke(ss, args);
//                } catch (IllegalAccessException|
//                        InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            });
        } catch (IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {
// Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}

public class A14_Apply {
}
