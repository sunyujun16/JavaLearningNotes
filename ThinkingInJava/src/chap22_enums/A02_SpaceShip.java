package chap22_enums;

import java.util.stream.*;

enum SpaceShip {
    SCOUT, CARGO, TRANSPORT,
    CRUISER, BATTLESHIP, MOTHERSHIP, ENTERPRISE;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase(); // 1:下标左边界
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        Stream.of(values())
                .forEach(System.out::println);
    }
}

public class A02_SpaceShip {
}
