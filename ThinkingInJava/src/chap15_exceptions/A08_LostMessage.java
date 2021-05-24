package chap15_exceptions;

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

class TrashException extends Exception {
    @Override
    public String toString() {
        return "A trash exception";
    }
}

public class A08_LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void g() throws TrashException {
        throw new TrashException();
    }

    public static void main(String[] args) {
        try {
            A08_LostMessage lm = new A08_LostMessage();
            try {
                lm.f();
            } catch (VeryImportantException e){
                System.out.println(e);
            } finally {
                try {
                    lm.dispose();
                } catch (HoHumException he) {
                    System.out.println(he);
                } finally {
                    lm.g();
                }
            }
        } catch (TrashException e) {
            System.out.println(e);
        }
    }
}

