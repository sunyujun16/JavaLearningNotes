package chap38_staticchecking.drc;

// {java staticchecking.drc.DogAndRobotCollections}

import java.util.*;

class Dog {
    public void talk() {
        System.out.println("Woof!");
    }

    public void reproduce() {
    }
}

class Robot {
    public void talk() {
        System.out.println("Click!");
    }

    public void oilChange() {
    }
}

public class DogAndRobotCollections {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        List<Robot> robotList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            dogList.add(new Dog());
        //- dogList.add(new Robot()); // Compile-time error
        for (int i = 0; i < 10; i++)
            robotList.add(new Robot());
        //- robotList.add(new Dog()); // Compile-time error
        dogList.forEach(Dog::talk);
        robotList.forEach(Robot::talk);
    }
}

// Java的限制还是比较烦人的
//class Communicate {
//    public static <T> void speak(T speaker) {
//        speaker.talk();
//    }
//}
