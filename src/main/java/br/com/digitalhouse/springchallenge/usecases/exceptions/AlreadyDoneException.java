package br.com.digitalhouse.springchallenge.usecases.exceptions;

public class AlreadyDoneException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public AlreadyDoneException(String message) { super(message); }
    public AlreadyDoneException(String message, Throwable cause) { super(message, cause); }
}
