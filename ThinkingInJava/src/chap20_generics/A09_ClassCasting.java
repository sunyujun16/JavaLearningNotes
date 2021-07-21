package chap20_generics;

import java.io.*;
import java.util.*;

class ClassCasting {
//    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0]));

        // Won't Compile:
//         List<Widget> lw1 = List<>.class.cast(in.readObject());
//         List<Widget> lw1 = List<Widget>.class.cast(in.readObject());

        List<Widget> lw2 = (List<Widget>) in.readObject();
        List<Widget> lw3 = List.class.cast(in.readObject());
        List<Widget> lw4 = (List<Widget>)List.class.cast(in.readObject());
    }
}

public class A09_ClassCasting {
}
