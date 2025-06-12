package com.dfperu.scotiabank.ms_alumno.controller;

import com.dfperu.scotiabank.ms_alumno.utils.JwtGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final JwtGenerator jwtGenerator;

    public AuthController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

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
