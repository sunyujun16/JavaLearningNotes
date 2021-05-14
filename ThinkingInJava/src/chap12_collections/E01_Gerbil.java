package chap12_collections;

import java.util.ArrayList;

public class E01_Gerbil {
    private int gerbilNumber;

    E01_Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    E01_Gerbil hop(){
        System.out.println(gerbilNumber + " is hopping.");
        return this;
    }

    private String get(){
        return "Gerbil No." + gerbilNumber;
    }

    @Override
    public String toString() {
        return "Gerbil No." + gerbilNumber;
    }

    public static void main(String[] args) {
        ArrayList<E01_Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new E01_Gerbil(i));
        }

        // 自带的get()方法, 获取List中的对象
        System.out.println(gerbils.get(0));
        System.out.println("-----------------");

        for (E01_Gerbil gerbil:gerbils) {
            System.out.println(gerbil.get());
            gerbil.hop();
            System.out.println("-----------------");
        }


    }
}


