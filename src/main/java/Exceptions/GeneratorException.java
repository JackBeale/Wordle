package Exceptions;

public class GeneratorException extends Exception{
    public GeneratorException(String errorMessage, Throwable e) {
        super(errorMessage, e);
    }
}
