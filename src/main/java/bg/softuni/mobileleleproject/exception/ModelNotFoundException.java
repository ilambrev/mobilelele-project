package bg.softuni.mobileleleproject.exception;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message) {
        super(message);
    }

    public ModelNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}