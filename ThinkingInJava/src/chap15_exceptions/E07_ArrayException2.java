package chap15_exceptions;

import java.io.*;
import java.util.logging.*;

public class E07_ArrayException2 {
    private Integer[] intArray = new Integer[10];

    E07_ArrayException2(){
        for (int i = 0; i < 10; i++) {
            intArray[i] = i;
        }
    }

    private static Logger logger = Logger.getLogger("E07_ArrayException2");

    private static void logException(Exception e){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        logger.severe(sw.toString());
    }

    public static void main(String[] args) {
        E03_ArrayException ea = new E03_ArrayException();

        try{
            ea.intArray[11] = 1;
        }catch (ArrayIndexOutOfBoundsException e){
            logException(e);
        }

    }

}
