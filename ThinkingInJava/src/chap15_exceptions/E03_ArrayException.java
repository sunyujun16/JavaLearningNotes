package chap15_exceptions;

public class E03_ArrayException {
    Integer[] intArray = new Integer[10];

    E03_ArrayException(){
        for (int i = 0; i < 10; i++) {
            intArray[i] = i;
        }
    }

    public static void main(String[] args) {
        E03_ArrayException ea = new E03_ArrayException();

        try{
            ea.intArray[11] = 1;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds");
        }

    }
}
