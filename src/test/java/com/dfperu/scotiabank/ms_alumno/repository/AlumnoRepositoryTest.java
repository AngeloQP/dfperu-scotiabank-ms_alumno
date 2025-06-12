package com.dfperu.scotiabank.ms_alumno.repository;

import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import reactor.test.StepVerifier;

@DataR2dbcTest
class AlumnoRepositoryTest {

    @Autowired
    private AlumnoRepository repository;

    @Test
    void testSaveAndFindById() {
        Alumno alumno = new Alumno(null, "Angelo", "Querevalu", 1, 23);

        repository.save(alumno)
                .flatMap(saved -> repository.findById(saved.getId()))
                .as(StepVerifier::create)
                .assertNext(found -> {
                    Assertions.assertEquals("Angelo", found.getNombre());
                    Assertions.assertEquals("Querevalu", found.getApellido());
                })
                .verifyComplete();
    }
}
