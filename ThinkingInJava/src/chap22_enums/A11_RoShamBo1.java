package chap22_enums;

import java.util.*;

import static chap22_enums.Outcome.*;

enum Outcome {WIN, LOSE, DRAW} // 由于要直接使用实例的字面量, 所以import了一下.

interface Item {
    Outcome compete(Item it);

    Outcome eval(Paper p);

    Outcome eval(Scissors s);

    Outcome eval(Rock r);
}

class Paper implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors s) {
        return WIN;  // 我草了...这种反人类的逻辑.
        // 怎么改才不反人类呢? 应该把compete的逻辑改一下, return 反的结果;
    }

    @Override
    public Outcome eval(Rock r) {
        return LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return LOSE;
    }

    @Override
    public Outcome eval(Scissors s) {
        return DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return WIN;
    }

    @Override
    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {
    @Override
    public Outcome compete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return WIN;
    }

    @Override
    public Outcome eval(Scissors s) {
        return LOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(
                a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++)
            match(newItem(), newItem()); // 两个Item类型均随机, 多路分发登场.
    }
}

public class A11_RoShamBo1 {
}
