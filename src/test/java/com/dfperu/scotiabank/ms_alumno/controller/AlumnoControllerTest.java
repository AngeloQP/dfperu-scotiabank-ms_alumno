package com.dfperu.scotiabank.ms_alumno.controller;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.service.AlumnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Pruebas unitarias para el controlador {@link AlumnoController},
 * utilizando WebFluxTest y WebTestClient.
 */
@WebFluxTest(controllers = AlumnoController.class)
@AutoConfigureWebTestClient
@Import(AlumnoControllerTest.TestSecurityConfig.class)
class AlumnoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AlumnoService alumnoService;

    /**
     * Prueba del endpoint POST /api/alumnos para guardar un alumno.
     * Se simula el servicio usando Mono.empty() y se espera una respuesta 200 OK.
     */
    @Test
    void testGuardarAlumno() {
        AlumnoDTO alumnoDTO = new AlumnoDTO(5L, "Angelo", "Querevalu", 1, 22);
        when(alumnoService.guardarAlumno(any())).thenReturn(Mono.empty());

        webTestClient.post()
                .uri("/api/alumnos")
                .bodyValue(alumnoDTO)
                .exchange()
                .expectStatus().isOk();
    }

    /**
     * Configuración de seguridad utilizada solo para pruebas,
     * que permite todas las solicitudes sin autenticación.
     */
    @TestConfiguration
    @EnableWebFluxSecurity
    static class TestSecurityConfig {

        @Bean
        public SecurityWebFilterChain testSecurityFilterChain(ServerHttpSecurity http) {
            return http
                    .csrf().disable()
                    .authorizeExchange(exchange -> exchange.anyExchange().permitAll())
                    .build();
        }
    }
}
