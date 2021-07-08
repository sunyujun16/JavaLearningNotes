package chap35_lowlevel;

import java.util.concurrent.CompletableFuture;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract class IntTestable implements Runnable, IntSupplier {
    abstract void evenIncrement();

    @Override
    public void run() {
        while (true)
            evenIncrement();
    }

    // 抽象类可以不实现接口? --- 是的.
//    @Override
//    public int getAsInt(){
//        return 1;
//    }


    public static void main(String[] args) {
        List<CompletableFuture<Void>> lc =
        IntStream.range(0, 10)
                .mapToObj(
                        x -> new IntTestable() {
                            private int n = 0;

                            @Override
                            void evenIncrement() {
                                n +=2 ;
                            }

                            @Override
                            public int getAsInt() {
                                return n;
                            }
                        }
                ).map(CompletableFuture::runAsync)
                .collect(Collectors.toList());
    }
}

public class A05_IntTestable {
}
