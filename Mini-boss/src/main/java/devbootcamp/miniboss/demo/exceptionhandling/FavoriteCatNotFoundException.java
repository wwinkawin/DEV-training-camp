package devbootcamp.miniboss.demo.exceptionhandling;

public class FavoriteCatNotFoundException extends RuntimeException{
    public FavoriteCatNotFoundException(){
        super("There is no saved favorite cat for this user");
    }

    public FavoriteCatNotFoundException(final String message){
        super(message);
    }
}
