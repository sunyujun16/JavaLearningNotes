package chap25_patterns.recyclea;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

abstract class Trash {
    double weight;

    Trash(double wt) {
        weight = wt;
    }

    abstract double value();

    // Sums the value of Trash in a bin:
    private static double val;

    static void sumValue(List<? extends Trash> bin) {
        val = 0.0f;
        bin.forEach(t -> {
            // Polymorphism in action:
            val += t.weight * t.value();
            System.out.println(
                    "weight of " +
                            // Using RTTI to get type
                            // information about the class:
                            t.getClass().getSimpleName() +
                            " = " + t.weight);
        });
        System.out.format("Total value = %.2f\n", val);
    }
}

class Aluminum extends Trash {
    static double val = 1.67f;

    Aluminum(double wt) {
        super(wt);
    }

    @Override
    double value() {
        return val;
    }

    static void value(double newval) {
        val = newval;
    }
}

class Paper extends Trash {
    static double val = 0.10f;

    Paper(double wt) {
        super(wt);
    }

    @Override
    double value() {
        return val;
    }

    static void value(double newval) {
        val = newval;
    }
}

class Glass extends Trash {
    static double val = 0.23f;

    Glass(double wt) {
        super(wt);
    }

    @Override
    double value() {
        return val;
    }

    static void value(double newval) {
        val = newval;
    }
}

class TrashFactory {
    static List<Function<Double, Trash>> ttypes =
            Arrays.asList(
                    Aluminum::new, Paper::new, Glass::new);
    static final int SZ = ttypes.size();
    private static SplittableRandom rand =
            new SplittableRandom(47);

    public static Trash newTrash() {
        return ttypes
                .get(rand.nextInt(SZ))
                .apply(rand.nextDouble());
    }
}

public class RecycleA {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        List<Trash> bin =
                Stream.generate(TrashFactory::newTrash)
                        .limit(25)
                        .collect(Collectors.toList());
        List<Glass> glassBin = new ArrayList<>();
        List<Paper> paperBin = new ArrayList<>();
        List<Aluminum> alBin = new ArrayList<>();

        // Sort the Trash:
        bin.forEach(t -> {
            // RTTI to discover Trash type:
            if (t instanceof Aluminum)
                alBin.add((Aluminum) t);
            if (t instanceof Paper)
                paperBin.add((Paper) t);
            if (t instanceof Glass)
                glassBin.add((Glass) t);
        });

        Trash.sumValue(alBin);
        Trash.sumValue(paperBin);
        Trash.sumValue(glassBin);
        Trash.sumValue(bin);
    }
}