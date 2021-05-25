package chap15_exceptions;

class Papa {
    public Papa() throws ArrayIndexOutOfBoundsException{
    }
}

class Son extends Papa{
    public Son() throws ArrayIndexOutOfBoundsException, NoSuchFieldException{
        // super() must be the 1st statement in clause, so there cant be any "try" block.
//        try{
//            super();
//        }
    }
}

public class E21_ConstructorExps {
    public static void main(String[] args) {
        try{
            Son son = new Son();
        } catch (ArrayIndexOutOfBoundsException | NoSuchFieldException e){
            System.out.println("Caught in main.");
        }
    }
}
