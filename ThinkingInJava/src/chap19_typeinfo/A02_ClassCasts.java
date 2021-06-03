package chap19_typeinfo;

class Building {
}

class House extends Building {
}

public class A02_ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b;  // ... or just do this.
    }
}
