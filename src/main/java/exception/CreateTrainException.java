package exception;

public class CreateTrainException extends Exception{
    public CreateTrainException(){
    }
    public CreateTrainException(String message,Throwable cause){
        super(message,cause);
    }
    public CreateTrainException(String message){
        super(message);
    }
    public CreateTrainException(Throwable cause){
        super(cause);
    }
}
