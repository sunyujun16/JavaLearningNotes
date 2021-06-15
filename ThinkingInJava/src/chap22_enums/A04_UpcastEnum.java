package chap22_enums;

// No values() method if you upcast an enum
enum Search {HITHER, YON}

class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast
//        e.values(); // No values() in Enum
        for (Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}

public class A04_UpcastEnum {
}
