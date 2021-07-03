package chap37_serialization;

// Restoring the state of the fictitious CAD system
// {RunFirst: AStoreCADState}

import java.io.*;
import java.util.*;

public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (
                ObjectInputStream in =
                        new ObjectInputStream(
                                new FileInputStream("CADState.dat"))
        ) {
            // Read in the same order they were written:
            List<Class<? extends Shape>> shapeTypes =
                    (List<Class<? extends Shape>>) in.readObject();
            Line.deserializeStaticState(in);
            List<Shape> shapes =
                    (List<Shape>) in.readObject();
            System.out.println(shapes);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
