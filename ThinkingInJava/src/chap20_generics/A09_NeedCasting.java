package chap20_generics;

import java.io.*;
import java.util.*;

class NeedCasting {
//    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0]));
        List<Widget> shapes = (List<Widget>) in.readObject();
        // 序列化的东西, 这不看附录肯定懵逼.
    }
}

public class A09_NeedCasting {
}
