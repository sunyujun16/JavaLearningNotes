package chap08_reusing_classes;

class Dumb {
    Dumb(){
        System.out.println("Here! Im an idiot.");
    }

    @Override
    public String toString() {
        return "An happy idiot.";
    }
}

public class E01_LazyInitialize {
    private Dumb dp;

    E01_LazyInitialize(){
        System.out.println("Dumb is not init now.");
        System.out.println("Its : " + dp);
        getHim();
        System.out.println("Its now : " + dp);
    }

    private void getHim(){
        System.out.println("Dumb~! Out here!!!");
        dp = new Dumb();
    }

    public static void main(String[] args) {
       new E01_LazyInitialize();
    }
}
