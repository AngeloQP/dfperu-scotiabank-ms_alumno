package com.dfperu.scotiabank.ms_alumno.service.impl;

import com.dfperu.scotiabank.ms_alumno.mapper.AlumnoMapper;
import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import com.dfperu.scotiabank.ms_alumno.model.enums.EstadoAlumno;
import com.dfperu.scotiabank.ms_alumno.repository.AlumnoRepository;
import com.dfperu.scotiabank.ms_alumno.service.AlumnoService;
import com.dfperu.scotiabank.ms_alumno.utils.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementación del servicio {@link AlumnoService} que gestiona la lógica de negocio
 * relacionada con los alumnos.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    /**
     * Repositorio para operaciones CRUD sobre entidades Alumno.
     */
    @Autowired
    private AlumnoRepository repository;

    /**
     * Componente encargado de mapear entre {@link AlumnoDTO} y {@link Alumno}.
     */
    @Autowired
    private AlumnoMapper mapper;

    /**
     * Guarda un nuevo alumno en el sistema si no existe previamente.
     * Aplica validaciones antes del guardado.
     *
     * @param alumnoDTO Objeto con los datos del alumno a registrar.
     * @return Mono<Void> que representa la finalización del proceso.
     */
    @Override
    @PreAuthorize("hasAuthority('SCOPE_write')")
    public Mono<Void> guardarAlumno(AlumnoDTO alumnoDTO) {
        return Validator.validarAlumno(alumnoDTO)
                .then(repository.existsById(alumnoDTO.id()))
                .flatMap(existe -> {
                    if (existe) {
                        return Validator.mostrarError("El alumno con ID " + alumnoDTO.id() + " ya existe.");
                    }
                    log.info("Alumno recibido: {}", alumnoDTO);
                    Alumno alumno = mapper.toEntity(alumnoDTO);
                    alumno.setId(null); // Se asegura de que sea un nuevo registro
                    log.info("Alumno mapeado con id null: {}", alumno);
                    return repository.save(alumno).then();
                });
    }

    /**
     * Retorna un flujo reactivo de alumnos cuyo estado es "ACTIVO".
     *
     * @return Flux<Alumno> flujo de alumnos activos.
     */
    @Override
    public Flux<Alumno> listarAlumnosActivos() {
        return repository.findByEstado(EstadoAlumno.ACTIVO.getValor());
    }
}
