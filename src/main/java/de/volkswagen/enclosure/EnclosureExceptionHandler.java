package de.volkswagen.enclosure;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EnclosureExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(EmptyEnclosureListException.class)
    public void handleEmptyEnclosureListException() { }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EnclosureNotFoundException.class)
    public void handleEnclosureNotFoundException() { }
}
