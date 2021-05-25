package chap15_exceptions;

// Catching exception hierarchies
class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class A12_Human {
    public static void main(String[] args) {
// Catch the exact type:
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
// Catch the base type:
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}

