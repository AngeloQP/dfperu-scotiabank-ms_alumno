package com.dfperu.scotiabank.ms_alumno.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * Manejador global de excepciones para la aplicación.
 * Captura excepciones comunes y devuelve respuestas apropiadas en formato reactivo.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones del tipo {@link IllegalArgumentException}.
     * Devuelve un mensaje de error con código HTTP 409 (CONFLICT).
     *
     * @param ex la excepción capturada
     * @return Mono<String> con el mensaje de la excepción
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Mono<String> handleIllegalArgument(IllegalArgumentException ex) {
        return Mono.just(ex.getMessage());
    }
}
