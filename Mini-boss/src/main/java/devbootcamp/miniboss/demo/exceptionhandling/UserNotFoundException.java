package devbootcamp.miniboss.demo.exceptionhandling;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("This user does not exist");
    }

    public UserNotFoundException(final String message){
        super(message);
    }
}
