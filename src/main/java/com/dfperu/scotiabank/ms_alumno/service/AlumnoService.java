package com.dfperu.scotiabank.ms_alumno.service;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {
    Mono<Void> guardarAlumno(AlumnoDTO alumnoDTO);
    Flux<Alumno> listarAlumnosActivos();
}
