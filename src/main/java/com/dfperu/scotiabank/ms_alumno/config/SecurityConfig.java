package com.dfperu.scotiabank.ms_alumno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.crypto.spec.SecretKeySpec;

/**
 * Configuración de seguridad para la aplicación usando Spring Security y WebFlux.
 * Define reglas de acceso y el mecanismo de decodificación de tokens JWT.
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    /**
     * Define las reglas de seguridad para las rutas de la aplicación.
     *
     * - Las rutas que comienzan con "/api/alumnos/**" requieren autenticación.
     * - Las demás rutas están permitidas sin autenticación.
     * - Se desactiva CSRF ya que es común en APIs REST.
     *
     * @param http configuración de seguridad reactiva
     * @return cadena de filtros de seguridad configurada
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf().disable()
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/api/alumnos/**").authenticated()
                        .anyExchange().permitAll()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                )
                .build();
    }

    /**
     * Configura el decodificador de JWT para verificar la firma HMAC con una clave secreta.
     *
     * @return una instancia de {@link ReactiveJwtDecoder} configurada con la clave secreta
     */
    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        SecretKeySpec secretKey = new SecretKeySpec(
                "clave-secreta-scotiabank-1234567890!".getBytes(),
                "HmacSHA256"
        );
        return NimbusReactiveJwtDecoder.withSecretKey(secretKey).build();
    }
}
