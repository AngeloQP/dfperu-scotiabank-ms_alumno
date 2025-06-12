package com.dfperu.scotiabank.ms_alumno.model.dao;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlumnoDTO(
        Long id,
        String nombre,
        String apellido,
        Integer estado,
        int edad
) {}
