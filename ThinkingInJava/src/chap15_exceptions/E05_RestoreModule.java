package chap15_exceptions;

public class E05_RestoreModule {

    Integer[] intArray = new Integer[10];

    E05_RestoreModule(){
        for (int i = 0; i < 10; i++) {
            intArray[i] = i;
        }
    }

    public static void main(String[] args) {
        E05_RestoreModule ea = new E05_RestoreModule();
        int j = 12;

        while(true){
            try{
                ea.intArray[j] = 1;
                System.out.println(j + " is within bounds now.");
                break;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Index Out Of Bounds: " + j);
                j--;
            }
        }

    }
}
