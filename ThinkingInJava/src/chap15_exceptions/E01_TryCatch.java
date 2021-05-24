package chap15_exceptions;

public class E01_TryCatch {
    public static void main(String[] args) {
        try{
            throw new Exception("haha");
        }catch (Exception e){
            System.out.println("Caught Exception.");
        }finally {
            System.out.println("The end.");
        }
    }
}
