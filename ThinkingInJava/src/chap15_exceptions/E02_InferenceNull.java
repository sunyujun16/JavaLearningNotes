package chap15_exceptions;

public class E02_InferenceNull {
    private void getEi(){
    }

    public static void main(String[] args) throws Exception{
        E02_InferenceNull ee = null;

        try {
            ee.getEi();
        }catch (NullPointerException e){
            System.out.println("null inference.");
        }

    }
}
