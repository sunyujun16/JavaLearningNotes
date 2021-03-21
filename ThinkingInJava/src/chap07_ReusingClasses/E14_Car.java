package chap07_ReusingClasses;

import java.awt.*;

class Engine {
    public void start() {
    }

    public void rev() {
    }

    public void service() {
        System.out.println("Service");
    }
}

class Wheel {
    public void inflate(int n) {
        System.out.println("Gas filled: " + n);
    }
}

class Window {
    public void rollUp() {
        System.out.println("Rolled up.");
    }

    public void rollDown() {
    }
}

class Door {
    Window window = new Window();

    public void open() {
    }

    public void close() {
    }
}

public class E14_Car {
    public Engine engine = new Engine();
    public Wheel[] wheels = new Wheel[4];
    public Door
            left = new Door(),
            right = new Door();

    public E14_Car() {
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        E14_Car car = new E14_Car();
        car.left.window.rollUp();
        car.wheels[1].inflate(90);
        car.engine.service();
    }

}
