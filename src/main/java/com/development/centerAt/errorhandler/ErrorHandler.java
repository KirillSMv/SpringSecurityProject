package com.development.centerAt.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    public final DateTimeFormatter TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(final MethodArgumentNotValidException exception) {
        log.error("exception ={}", exception.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage(), LocalDateTime.now().format(TIME_PATTERN));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(final IllegalArgumentException exception) {
        log.error("Exception: {}", exception.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage(), LocalDateTime.now().format(TIME_PATTERN));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(final MissingServletRequestParameterException exception) {
        log.error("MissingServletRequestParameterException:", exception);
        return new ErrorResponse(Arrays.toString(exception.getStackTrace()), exception.getMessage(), LocalDateTime.now().format(TIME_PATTERN));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handle(final MissingPathVariableException exception) {
        log.error("MissingPathVariableException:", exception);
        return new ErrorResponse(Arrays.toString(exception.getStackTrace()), exception.getMessage(), LocalDateTime.now().format(TIME_PATTERN));
    }
}
