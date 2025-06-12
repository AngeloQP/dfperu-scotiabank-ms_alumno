package com.dfperu.scotiabank.ms_alumno.utils;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.enums.EstadoAlumno;
import reactor.core.publisher.Mono;

/**
 * Clase utilitaria para realizar validaciones personalizadas sobre objetos del dominio.
 */
public class Validator {

    /**
     * Valida los campos de un objeto {@link AlumnoDTO}.
     * Verifica que todos los campos obligatorios estén presentes y con valores válidos.
     *
     * @param alumnoDTO el objeto a validar
     * @return Mono.empty() si es válido, o Mono.error con un {@link IllegalArgumentException} si hay errores
     */
    public static Mono<Void> validarAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO.id() == null) {
            return Mono.error(new IllegalArgumentException("El id del alumno es obligatorio."));
        }
        if (alumnoDTO.nombre() == null || alumnoDTO.nombre().trim().isEmpty()) {
            return Mono.error(new IllegalArgumentException("El nombre del alumno es obligatorio."));
        }
        if (alumnoDTO.apellido() == null || alumnoDTO.apellido().trim().isEmpty()) {
            return Mono.error(new IllegalArgumentException("El apellido del alumno es obligatorio."));
        }
        if (alumnoDTO.estado() == null ||
                (alumnoDTO.estado() != EstadoAlumno.ACTIVO.getValor() &&
                        alumnoDTO.estado() != EstadoAlumno.INACTIVO.getValor())) {
            return Mono.error(new IllegalArgumentException("El estado del alumno es inválido."));
        }
        if (alumnoDTO.edad() <= 0) {
            return Mono.error(new IllegalArgumentException("La edad debe ser mayor a 0."));
        }
        return Mono.empty();
    }

    /**
     * Devuelve un error reactivo con el mensaje especificado.
     *
     * @param error el mensaje de error a retornar
     * @return Mono.error con una excepción {@link IllegalArgumentException}
     */
    public static Mono<Void> mostrarError(String error) {
        return Mono.error(new IllegalArgumentException(error));
    }
}
