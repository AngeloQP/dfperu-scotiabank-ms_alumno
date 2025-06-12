package com.dfperu.scotiabank.ms_alumno.repository;

import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Repositorio reactivo para realizar operaciones CRUD sobre la entidad {@link Alumno}.
 * Extiende {@link ReactiveCrudRepository} para aprovechar soporte completo de reactividad con Project Reactor.
 */
@Repository
public interface AlumnoRepository extends ReactiveCrudRepository<Alumno, Long> {

    /**
     * Retorna un flujo de alumnos filtrados por su estado.
     *
     * @param estado valor del estado a filtrar (por ejemplo: 0 = ACTIVO, 1 = INACTIVO)
     * @return {@link Flux} de alumnos que coinciden con el estado especificado
     */
    Flux<Alumno> findByEstado(int estado);
}
