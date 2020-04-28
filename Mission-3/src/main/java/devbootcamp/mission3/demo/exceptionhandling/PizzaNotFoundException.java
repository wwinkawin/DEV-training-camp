package devbootcamp.mission3.demo.exceptionhandling;

public class PizzaNotFoundException extends RuntimeException{
    public PizzaNotFoundException(){
        super("There is no corresponding pizza in database");
    }

    public PizzaNotFoundException(final String message){
        super(message);
    }
}
