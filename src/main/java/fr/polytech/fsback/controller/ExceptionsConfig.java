package fr.polytech.fsback.controller;

import fr.polytech.fsback.dto.responses.ErrorMessageDto;
import fr.polytech.fsback.exception.InvalidValueException;
import fr.polytech.fsback.exception.ResourceDoesntExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionsConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageDto internalServerError(Exception ex) {
        ex.printStackTrace();
        return new ErrorMessageDto("INTERNAL_ERROR", null);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto internalServerError(MethodArgumentNotValidException ex) {
        return new ErrorMessageDto("BAD_REQUEST", null);
    }

    @ExceptionHandler(value = InvalidValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto internalServerError(InvalidValueException ex) {
        return new ErrorMessageDto("BAD_REQUEST", null);
    }

    @ExceptionHandler(value = ResourceDoesntExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageDto notFoundError(ResourceDoesntExistException ex) {
        return new ErrorMessageDto("NOT_FOUND", ex.getMessage());
    }
}
