package com.dfperu.scotiabank.ms_alumno.repository;

import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AlumnoRepository extends ReactiveCrudRepository<Alumno, Long> {
    Flux<Alumno> findByEstado(int estado);
}
