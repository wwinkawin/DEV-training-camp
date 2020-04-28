package devbootcamp.mission3.demo.exceptionhandling;

public class MandatoryIsNullException extends RuntimeException{
    public MandatoryIsNullException(){
        super();
    }
    public MandatoryIsNullException(final String message){
        super(message);
    }
}
