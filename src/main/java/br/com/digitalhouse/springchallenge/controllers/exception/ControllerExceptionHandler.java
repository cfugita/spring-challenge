package br.com.digitalhouse.springchallenge.controllers.exception;

import br.com.digitalhouse.springchallenge.usecases.exceptions.AlreadyDoneException;
import br.com.digitalhouse.springchallenge.usecases.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Calendar;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFound (NotFoundException e) {

        StandardError err = new StandardError(
                Calendar.getInstance().getTime(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(AlreadyDoneException.class)
    public ResponseEntity<Object> alreadyDone (AlreadyDoneException e) {
        StandardError err = new StandardError(
                Calendar.getInstance().getTime(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
