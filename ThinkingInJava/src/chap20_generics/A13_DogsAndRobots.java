package chap20_generics;

// No (direct) latent typing in Java

import chap19_typeinfo.pets.*;

class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }

    @Override
    public void sit() {
        System.out.println("Sitting");
    }

    public void reproduce() {
    }
}

class Robot implements Performs {
    public void speak() {
        System.out.println("Robot: Click!");
    }

    public void sit() {
        System.out.println("Robot Clank!");
    }

    public void oilChange() {
    }
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

class DogsAndRobots {
    public static void main(String[] args) {
        Communicate.perform(new PerformingDog());
        Communicate.perform(new Robot());
    }
}

public class A13_DogsAndRobots {
}
