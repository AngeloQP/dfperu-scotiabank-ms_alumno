package com.dfperu.scotiabank.ms_alumno.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    private static final String SECRET_KEY = "clave-secreta-scotiabank-1234567890!";
    private static final long EXPIRATION_TIME_MS = 86400000;

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
