package exceptions;

public class PersonNegativeAgeRunTimeException extends RuntimeException{

     public PersonNegativeAgeRunTimeException(String message) {
        super(message);
    }
}
