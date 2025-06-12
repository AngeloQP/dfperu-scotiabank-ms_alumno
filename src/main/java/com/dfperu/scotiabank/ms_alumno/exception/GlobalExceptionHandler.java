package com.dfperu.scotiabank.ms_alumno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Mono<String> handleIllegalArgument(IllegalArgumentException ex) {
        return Mono.just(ex.getMessage());
    }
}
