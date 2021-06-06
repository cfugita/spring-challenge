package br.com.digitalhouse.springchallenge.usecases.exceptions;

public class IllegalArgumentException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public IllegalArgumentException(String message) { super(message); }
    public IllegalArgumentException(String message, Throwable cause) { super(message, cause); }
}
