package chap20_generics;

// "Assisted Latent Typing"

import chap19_typeinfo.pets.*;

import java.util.function.*;

class PerformingDogA extends Dog {
    public void speak() {
        System.out.println("PerformingDogA Woof!");
    }

    public void sit() {
        System.out.println("PerformingDogA Sitting");
    }

    public void reproduce() {
    }
}

class RobotA {
    public void speak() {
        System.out.println("RobotA Click!");
    }

    public void sit() {
        System.out.println("RobotA Clank!");
    }

    public void oilChange() {
    }
}

class CommunicateA {
    public static <P> void perform(P performer, Consumer<P> action1,
                                   Consumer<P> action2)
    {
        action1.accept(performer);
        action2.accept(performer);
    }
}

class DogsAndRobotMethodReferences {
    public static void main(String[] args) {
        CommunicateA.perform(new PerformingDogA(),
                PerformingDogA::speak, PerformingDogA::sit);

        CommunicateA.perform(new RobotA(),
                RobotA::speak, RobotA::sit);

        CommunicateA.perform(new Mime(),
                Mime::walkAgainstTheWind,
                Mime::pushInvisibleWalls);
    }
}

public class A15_DogsAndRobotMethodReferences {
}
