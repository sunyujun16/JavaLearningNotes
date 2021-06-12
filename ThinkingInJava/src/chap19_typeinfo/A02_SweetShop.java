package chap19_typeinfo;

import java.lang.Class;
import java.lang.reflect.InvocationTargetException;

// 检查类加载器工作方式
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

public class A02_SweetShop {
    public static void main(String[] args){
        System.out.println("inside main");

        new Candy();
        System.out.println("After creating Candy");

        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }

        System.out.println("After Class.forName(\"Gum\")");

        new Cookie();
        System.out.println("After creating Cookie");

        System.out.println();

        if (args == null) return;
        try {
            Class cc =  Class.forName(args[0]+"."+args[1]); //初始化发生在这
            cc.getDeclaredConstructor().newInstance(); // 不在这
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
