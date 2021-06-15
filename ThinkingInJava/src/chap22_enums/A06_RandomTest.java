package chap22_enums;

import onjava.*;

enum Activity {
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING
}

class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.println(
                    Enums.random(Activity.class) + " ");
    }
}

public class A06_RandomTest {
}
