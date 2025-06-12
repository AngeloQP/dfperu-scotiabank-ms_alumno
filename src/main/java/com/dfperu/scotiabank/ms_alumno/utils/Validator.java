package com.dfperu.scotiabank.ms_alumno.utils;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.enums.EstadoAlumno;
import reactor.core.publisher.Mono;

public class Validator {

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
                (alumnoDTO.estado() != EstadoAlumno.ACTIVO.getValor() && alumnoDTO.estado() != EstadoAlumno.INACTIVO.getValor())) {
            return Mono.error(new IllegalArgumentException("El estado del alumno es inválido."));
        }
        if (alumnoDTO.edad() <= 0) {
            return Mono.error(new IllegalArgumentException("La edad debe ser mayor a 0."));
        }
        return Mono.empty();
    }

    public static Mono<Void> mostrarError(String error){
        return Mono.error(new IllegalArgumentException(error));
    }
}
