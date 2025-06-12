package com.dfperu.scotiabank.ms_alumno.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Componente responsable de generar tokens JWT para autenticación.
 */
@Component
public class JwtGenerator {

    /**
     * Clave secreta utilizada para firmar el token.
     * Nota: En un entorno real, esta clave debe almacenarse de forma segura (por ejemplo, en una variable de entorno).
     */
    private static final String SECRET_KEY = "clave-secreta-scotiabank-1234567890!";

    /**
     * Tiempo de expiración del token en milisegundos (24 horas).
     */
    private static final long EXPIRATION_TIME_MS = 86400000;

    /**
     * Genera un token JWT firmado usando el nombre de usuario como subject.
     *
     * @param username nombre del usuario autenticado
     * @return token JWT generado
     */
    public String generateToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME_MS);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }
}
