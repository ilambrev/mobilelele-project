package bg.softuni.mobileleleproject.exceptions;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message) {
        super(message);
    }

    public ModelNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}