package chap19_typeinfo;

import java.util.*;

public class A08_SnowRemovalRobot implements A08_Robot {
    private String name;

    public A08_SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    private List<A08_Operation> ops = Arrays.asList(
            new A08_Operation(
                    () -> name + " can shovel snow",
                    () -> System.out.println(
                            name + " shoveling snow")),
            new A08_Operation(
                    () -> name + " can chip ice",
                    () -> System.out.println(name + " chipping ice")),
            new A08_Operation(
                    () -> name + " can clear the roof",
                    () -> System.out.println(
                            name + " clearing roof"))
    );

    public List<A08_Operation> operations() {
        return ops;
    }

    public static void main(String[] args) {
        A08_Robot.test(new A08_SnowRemovalRobot("Slusher"));
    }
}