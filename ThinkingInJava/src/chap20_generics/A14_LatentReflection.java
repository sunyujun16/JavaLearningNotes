package chap20_generics;

// Using reflection for latent typing

import java.lang.reflect.*;

// Does not implement Performs:
class Mime {
    public void walkAgainstTheWind() {
        System.out.println("walkAgainstTheWind");
    }

    public void sit() {
        System.out.println("Mime Pretending to sit");
    }

    public void pushInvisibleWalls() {
        System.out.println("pushInvisibleWalls");
    }

    @Override
    public String toString() {
        return "Mime";
    }
}

// Does not implement Performs:
class SmartDog {
    public void speak() {
        System.out.println("SmartDog Woof!");
    }

    public void sit() {
        System.out.println("SmartDog Sitting");
    }

    public void reproduce() {
    }

    @Override
    public String toString() {
        return "SmartDog";
    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot speak");
            }
            try {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                System.out.println(speaker + " cannot sit");
            }
        } catch (SecurityException |
                IllegalAccessException |
                IllegalArgumentException |
                InvocationTargetException e) {
            throw new RuntimeException(speaker.toString(), e);
            // (message, cause)
        }
    }
}

class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}

public class A14_LatentReflection {
}
