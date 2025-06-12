package com.dfperu.scotiabank.ms_alumno.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("alumno")
public class Alumno {

    @Id
    @Column("id")
    private Long id;

    @Column("nombre")
    private String nombre;

    @Column("apellido")
    private String apellido;

    @Column("estado")
    private int estado;

    @Column("edad")
    private int edad;

}
