package chap35_lowlevel;

import java.util.function.*;

abstract class IntTestable implements Runnable, IntSupplier {
    abstract void evenIncrement();

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    // 抽象类可以不实现接口?
//    @Override
//    public int getAsInt(){
//        return 1;
//    }
}

public class A05_IntTestable {
}
