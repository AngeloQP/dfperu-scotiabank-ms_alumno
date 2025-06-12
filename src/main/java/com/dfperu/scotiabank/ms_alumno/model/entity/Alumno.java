package com.dfperu.scotiabank.ms_alumno.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entidad que representa la tabla "alumno" en la base de datos.
 * Contiene los datos básicos de un alumno.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("alumno")
public class Alumno {

    /**
     * Identificador único del alumno.
     */
    @Id
    @Column("id")
    private Long id;

    /**
     * Nombre del alumno.
     */
    @Column("nombre")
    private String nombre;

    /**
     * Apellido del alumno.
     */
    @Column("apellido")
    private String apellido;

    /**
     * Estado del alumno (por ejemplo: 0 = activo, 1 = inactivo).
     */
    @Column("estado")
    private int estado;

    /**
     * Edad del alumno.
     */
    @Column("edad")
    private int edad;

}
