package chap25_patterns;

// Demonstration of multiple dispatching

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import onjava.*;

import static onjava.Tuple.*;

enum Outcome {WIN, LOSE, DRAW}

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
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.LOSE;
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
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.WIN;
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
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors s) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock";
    }
}

class ItemFactory {
    static List<Supplier<Item>> items =
            Arrays.asList(
                    Scissors::new, Paper::new, Rock::new);
    static final int SZ = items.size();
    private static SplittableRandom rand =
            new SplittableRandom(47);

    private static Item newItem() {
        return items.get(rand.nextInt(SZ)).get();
    }

    public static Tuple2<Item, Item> newPair() {
        return tuple(newItem(), newItem());
    }
}

class Compete {
    public static Outcome match(Tuple2<Item, Item> p) {
        System.out.print(p.a1 + " -> " + p.a2 + " : ");
        return p.a1.compete(p.a2);
    }
}

class PaperScissorsRock {
    public static void main(String[] args) {
        Stream.generate(ItemFactory::newPair)
                .limit(20)
                .map(Compete::match)
                .forEach(System.out::println);
    }
}

public class A09_PaperScissorsRock {
}
