package de.volkswagen.enclosure;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EnclosureExceptionHandler {

    @ResponseStatus(IM_USED)
    @ExceptionHandler(EnclosureAlreadyPresentException.class)
    public void handleEnclosureAlreadyPresentException() { }

    @ResponseStatus(NO_CONTENT)
    @ExceptionHandler(EmptyEnclosureListException.class)
    public void handleEmptyEnclosureListException() { }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EnclosureNotFoundException.class)
    public void handleEnclosureNotFoundException() { }
}
