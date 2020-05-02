package devbootcamp.miniboss.demo.exceptionhandling;

public class CatServiceException extends Exception {
    public CatServiceException() {
        super("Internal Error");
    }

    public CatServiceException(final String message) {
        super(message);
    }
}
