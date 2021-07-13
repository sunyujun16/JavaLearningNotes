package chap14_streams;

import java.util.*;
import onjava.Operations;

public class A02_Machine2 {
    public static void main(String[] args) {
        Arrays.stream(new Operations[]{
                () -> Operations.show("Bing"),
                () -> Operations.show("Crack"),
                () -> Operations.show("Twist"),
                () -> Operations.show("Pop")
        }).forEach(Operations::execute);

        // 同样效果, 但runOps源码是对数组使用了显式的for each迭代.
        //noinspection RedundantArrayCreation
        Operations.runOps(new Operations[]{
                () -> Operations.show("Bing"),
                () -> Operations.show("Crack"),
                () -> Operations.show("Pop"),
                () -> Operations.show("Twist")
        });

    }
}
