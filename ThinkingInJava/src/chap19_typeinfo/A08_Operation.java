package chap19_typeinfo;

import java.util.function.*;

public class A08_Operation {
    public final Supplier<String> description;
    public final Runnable command;

    public A08_Operation(Supplier<String> descr, Runnable cmd) {
        description = descr;
        command = cmd;
    }
}
