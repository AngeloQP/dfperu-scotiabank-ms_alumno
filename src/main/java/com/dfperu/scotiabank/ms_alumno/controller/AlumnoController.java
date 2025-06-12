package com.dfperu.scotiabank.ms_alumno.controller;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import com.dfperu.scotiabank.ms_alumno.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador REST para gestionar operaciones relacionadas con alumnos.
 * Proporciona endpoints para guardar alumnos y listar alumnos activos.
 */
@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    /**
     * Servicio que contiene la lógica de negocio para las operaciones con alumnos.
     */
    @Autowired
    private AlumnoService alumnoService;

    /**
     * Guarda un nuevo alumno en el sistema.
     *
     * @param alumnoDTO Objeto que contiene los datos del alumno a guardar.
     * @return Mono<Void> que representa la finalización del proceso de guardado.
     */
    @PostMapping
    public Mono<Void> guardar(@Valid @RequestBody AlumnoDTO alumnoDTO) {
        return alumnoService.guardarAlumno(alumnoDTO);
    }

    /**
     * Lista todos los alumnos que están activos.
     *
     * @return Flux<Alumno> flujo reactivo que contiene la lista de alumnos activos.
     */
    @GetMapping("/activos")
    public Flux<Alumno> listarActivos() {
        return alumnoService.listarAlumnosActivos();
    }
}
