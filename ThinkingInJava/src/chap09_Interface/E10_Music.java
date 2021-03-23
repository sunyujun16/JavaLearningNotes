package chap09_Interface;

enum Note {
    MIDDLE_B, MIDDLE_C, SHARP_E,
}

interface Instrument {
    // Compile-time constant:
    int VALUE = 5; // static & final

    default void play(Note n) { // Automatically public
        System.out.println(this + ".play() " + n);
    }
}

interface Adjustbale{
    default void adjust(Note note) {
        System.out.println("Adjusting distinguished ... " + this + " " + note);
    }
}

class Wind implements Instrument, Adjustbale{
    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument, Adjustbale {
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument, Adjustbale {
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class E10_Music {
    // Doesn't care about type, so new types
// added to the system still work right:
    private static void tune(Adjustbale i) {
// ...
        i.adjust(Note.MIDDLE_C);
    }

    private static void tuneAll(Adjustbale[] e) {
        for (Adjustbale a : e)
            tune(a);
    }

    public static void main(String[] args) {
// Upcasting during addition to the array:
        Adjustbale[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
