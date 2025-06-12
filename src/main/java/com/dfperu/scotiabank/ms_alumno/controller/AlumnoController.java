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

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public Mono<Void> guardar(@Valid @RequestBody AlumnoDTO alumnoDTO) {
        return alumnoService.guardarAlumno(alumnoDTO);
    }

    @GetMapping("/activos")
    public Flux<Alumno> listarActivos() {
        return alumnoService.listarAlumnosActivos();
    }
}
