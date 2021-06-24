package chap25_patterns.trash;

public class Cardboard extends Trash {
    private static double val = 0.23f;

    public Cardboard(double wt) {
        super(wt);
    }

    @Override
    public double value() {
        return val;
    }

    public static void value(double newVal) {
        val = newVal;
    }
}
