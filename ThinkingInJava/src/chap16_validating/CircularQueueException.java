package chap16_validating;

public class CircularQueueException extends RuntimeException {
    public CircularQueueException(String why) {
        super(why);
    }
}
