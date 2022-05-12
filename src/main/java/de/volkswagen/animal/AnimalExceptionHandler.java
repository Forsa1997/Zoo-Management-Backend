package de.volkswagen.animal;

import static org.springframework.http.HttpStatus.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AnimalExceptionHandler {

    @ResponseStatus(IM_USED)
    @ExceptionHandler(AnimalAlreadyPresentException.class)
    public void handleAnimalAlreadyPresentException() { }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(AnimalNotFoundException.class)
    public void handleAnimalNotFoundException() { }
}
