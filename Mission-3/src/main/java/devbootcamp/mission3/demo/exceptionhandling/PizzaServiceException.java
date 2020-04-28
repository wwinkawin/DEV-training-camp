package devbootcamp.mission3.demo.exceptionhandling;

public class PizzaServiceException extends Exception{
    public PizzaServiceException() {
        super("Internal Error");
    }

    public PizzaServiceException(final String message) {
        super(message);
    }
}
