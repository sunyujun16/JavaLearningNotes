package chap25_patterns.trashvisitor;

import chap25_patterns.trash.*;

import java.util.*;

// Specific group of algorithms packaged
// in each implementation of Visitor:
class PriceVisitor implements Visitor {
    private double alSum; // Aluminum
    private double pSum; // Paper
    private double gSum; // Glass
    private double cSum; // Cardboard

    public static void show(String s) {
        System.out.println(s);
    }

    @Override
    public void visit(Aluminum al) {
        double v = al.weight() * al.value();
        show("value of Aluminum= " + v);
        alSum += v;
    }

    @Override
    public void visit(Paper p) {
        double v = p.weight() * p.value();
        show("value of Paper= " + v);
        pSum += v;
    }

    @Override
    public void visit(Glass g) {
        double v = g.weight() * g.value();
        show("value of Glass= " + v);
        gSum += v;
    }

    @Override
    public void visit(Cardboard c) {
        double v = c.weight() * c.value();
        show("value of Cardboard = " + v);
        cSum += v;
    }

    @Override
    public void total() {
        show(
                "Total Aluminum: $" + alSum + "\n" +
                        "Total Paper: $" + pSum + "\n" +
                        "Total Glass: $" + gSum + "\n" +
                        "Total Cardboard: $" + cSum);
    }
}

class WeightVisitor implements Visitor {
    private double alSum; // Aluminum
    private double pSum; // Paper
    private double gSum; // Glass
    private double cSum; // Cardboard

    public static void show(String s) {
        System.out.println(s);
    }

    @Override
    public void visit(Aluminum al) {
        alSum += al.weight();
        show("Aluminum weight = " + al.weight());
    }

    @Override
    public void visit(Paper p) {
        pSum += p.weight();
        show("Paper weight = " + p.weight());
    }

    @Override
    public void visit(Glass g) {
        gSum += g.weight();
        show("Glass weight = " + g.weight());
    }

    @Override
    public void visit(Cardboard c) {
        cSum += c.weight();
        show("Cardboard weight = " + c.weight());
    }

    @Override
    public void total() {
        show("Total weight Aluminum:" + alSum);
        show("Total weight Paper:" + pSum);
        show("Total weight Glass:" + gSum);
        show("Total weight Cardboard:" + cSum);
    }
}

public class TrashVisitor {
    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();

        // ParseTrash still works, without changes:
        ParseTrash.fillBin("trashvisitor", bin);

        List<Visitor> visitors = Arrays.asList(
                new PriceVisitor(), new WeightVisitor());

        bin.forEach(t -> {
            Visitable v = (Visitable) t;
            visitors.forEach(visitor -> v.accept(visitor));
        });

        visitors.forEach(Visitor::total);
    }
}
