package exceptions;

public class OccupiedSeatException extends Exception {
    public OccupiedSeatException(String message) {
        super(message);
    }
}
