package com.dfperu.scotiabank.ms_alumno.service;

import com.dfperu.scotiabank.ms_alumno.mapper.AlumnoMapper;
import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import com.dfperu.scotiabank.ms_alumno.repository.AlumnoRepository;
import com.dfperu.scotiabank.ms_alumno.service.impl.AlumnoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias para {@link AlumnoServiceImpl}.
 * Se verifica el comportamiento del servicio bajo distintas condiciones de entrada.
 */
@ExtendWith(MockitoExtension.class)
class AlumnoServiceTest {

    @Mock
    private AlumnoRepository repository;

    @Mock
    private AlumnoMapper mapper;

    @InjectMocks
    private AlumnoServiceImpl alumnoService;

    /**
     * Verifica que un alumno nuevo sea guardado correctamente cuando no existe en el repositorio.
     */
    @Test
    void testGuardarAlumnoCuandoNoExiste() {
        AlumnoDTO dto = new AlumnoDTO(1L, "Angelo", "Querevalu", 1, 25);
        Alumno alumno = new Alumno(1L, "Angelo", "Querevalu", 1, 25);

        when(repository.existsById(1L)).thenReturn(Mono.just(false));
        when(mapper.toEntity(dto)).thenReturn(alumno);
        when(repository.save(alumno)).thenReturn(Mono.just(alumno));

        alumnoService.guardarAlumno(dto)
                .as(StepVerifier::create)
                .verifyComplete();

        verify(repository).save(alumno);
    }

    /**
     * Verifica que se retorne un error si el nombre del alumno es nulo.
     * También asegura que no se intente guardar el alumno.
     */
    @Test
    void testGuardarAlumnoConNombreNulo() {
        AlumnoDTO dto = new AlumnoDTO(1L, null, "Querevalu", 1, 25);

        when(repository.existsById(1L)).thenReturn(Mono.just(false)); 

        alumnoService.guardarAlumno(dto)
                .as(StepVerifier::create)
                .expectErrorMatches(throwable ->
                        throwable instanceof IllegalArgumentException &&
                                throwable.getMessage().equals("El nombre del alumno es obligatorio."))
                .verify();

        verify(repository, never()).save(any());
    }

    /**
     * Verifica que no se guarde un alumno si ya existe en el sistema (por su ID).
     * Se espera un error con un mensaje adecuado.
     */
    @Test
    void testGuardarAlumnoYaExiste() {
        AlumnoDTO dto = new AlumnoDTO(1L, "Angelo", "Querevalu", 1, 25);

        when(repository.existsById(1L)).thenReturn(Mono.just(true));

        alumnoService.guardarAlumno(dto)
                .as(StepVerifier::create)
                .expectErrorMatches(throwable ->
                        throwable instanceof IllegalArgumentException &&
                                throwable.getMessage().equals("El alumno con ID 1 ya existe."))
                .verify();

        verify(repository, never()).save(any());
    }
}
