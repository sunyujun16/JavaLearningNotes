package chap16_validating;

public class CircularQueueException extends RuntimeException {
    public CircularQueueException(String why) {
        super(why);
    }

    public static void main(String[] args) {
        boolean b = !false && false;
        System.out.println(b);
    }
}
