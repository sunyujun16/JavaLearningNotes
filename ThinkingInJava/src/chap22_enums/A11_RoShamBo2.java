package chap22_enums;

import static chap22_enums.Outcome.*;

import onjava.*;

import java.util.function.Consumer;
import java.util.function.Supplier;

interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}


class RoShamBo {
    public static <T extends Competitor<T>>
    void match(T a, T b) {
        System.out.println(
                a + " vs. " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>>
    void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++)
            match(Enums.random(rsbClass), Enums.random(rsbClass));
    }
}

enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN, n -> System.out.println(--n)),
    SCISSORS(WIN, DRAW, LOSE, n -> System.out.println(n)),
    ROCK(LOSE, WIN, DRAW, n -> System.out.println("" + ++n));
    private Outcome vPAPER, vSCISSORS, vROCK;
    private Consumer<Integer> cons;

    // 思路: 利用枚举类型可以通过构造器而具备不同的成员变量值的特点, 为每个枚举类型
    // 分配不同的特性.
    RoShamBo2(Outcome paper,
              Outcome scissors, Outcome rock, Consumer<Integer> cons) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
        this.cons = cons;
    }

    @Override
    public Outcome compete(RoShamBo2 it) {
        System.out.println();
        this.cons.accept(0);
        switch (it) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 10);
    }
}

public class A11_RoShamBo2 {
}
