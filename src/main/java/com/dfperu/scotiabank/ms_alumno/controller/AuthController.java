package com.dfperu.scotiabank.ms_alumno.controller;

import com.dfperu.scotiabank.ms_alumno.utils.JwtGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la autenticación de usuarios.
 * Proporciona un endpoint de login que genera un token JWT para el usuario autenticado.
 */
@RestController
@RequestMapping("api/auth")
public class AuthController {

    /**
     * Generador de tokens JWT utilizado para emitir tokens de autenticación.
     */
    private final JwtGenerator jwtGenerator;

    /**
     * Constructor para inyectar el generador de tokens JWT.
     *
     * @param jwtGenerator el componente responsable de generar el token JWT
     */
    public AuthController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    /**
     * Endpoint de autenticación que valida las credenciales del usuario y genera un token JWT.
     *
     * @param username nombre de usuario
     * @param password contraseña del usuario
     * @return ResponseEntity con el token JWT si las credenciales son válidas,
     *         o con un mensaje de error si son inválidas.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            String token = jwtGenerator.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
