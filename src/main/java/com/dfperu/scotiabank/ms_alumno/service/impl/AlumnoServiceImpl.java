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

@Slf4j
@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Autowired
    private AlumnoMapper mapper;

    @Override
    @PreAuthorize("hasAuthority('SCOPE_write')")
    public Mono<Void> guardarAlumno(AlumnoDTO alumnoDTO) {
        return Validator.validarAlumno(alumnoDTO).then(repository.existsById(alumnoDTO.id()))
                .flatMap(existe -> {
                    if (existe) {
                        return Validator.mostrarError("El alumno con ID " + alumnoDTO.id() + " ya existe.");
                    }
                    log.info("Alumno recibido: {}", alumnoDTO);
                    Alumno alumno = mapper.toEntity(alumnoDTO);
                    alumno.setId(null);
                    log.info("Alumno mapeado con id null: {}", alumno);
                    return repository.save(alumno).then();
                });
    }

    @Override
    public Flux<Alumno> listarAlumnosActivos() {
        return repository.findByEstado(EstadoAlumno.ACTIVO.getValor());
    }
}
