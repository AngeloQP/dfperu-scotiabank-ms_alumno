package com.dfperu.scotiabank.ms_alumno.service;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz que define los servicios relacionados con la gestión de alumnos.
 */
public interface AlumnoService {

    /**
     * Guarda un nuevo alumno en el sistema.
     *
     * @param alumnoDTO objeto que contiene los datos del alumno a guardar
     * @return Mono<Void> que indica la finalización del proceso de guardado
     */
    Mono<Void> guardarAlumno(AlumnoDTO alumnoDTO);

    /**
     * Obtiene una lista reactiva de alumnos que están activos.
     *
     * @return Flux<Alumno> flujo que contiene los alumnos activos
     */
    Flux<Alumno> listarAlumnosActivos();
}
