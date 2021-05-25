package chap15_exceptions;

class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();

    Reporter() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {
}

class Second extends Reporter {
}

public class A11_AutoCloseableDetails {
    public static void main(String[] args) {
        try (
                First f = new First();
                Second s = new Second()
        ) {
        }
    }
}


