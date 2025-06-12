package com.dfperu.scotiabank.ms_alumno.model.dao;

/**
 * DTO (Data Transfer Object) que representa los datos de un alumno
 * que serán recibidos o enviados desde/hacia el cliente.
 *
 * Este objeto es utilizado para transportar datos sin exponer directamente la entidad.
 *
 * @param id       Identificador del alumno. Puede ser null al momento de creación.
 * @param nombre   Nombre del alumno. No debe estar en blanco.
 * @param apellido Apellido del alumno. No debe estar en blanco.
 * @param estado   Estado del alumno (por ejemplo, activo/inactivo). No debe ser null.
 * @param edad     Edad del alumno. Debe estar entre 1 y 120.
 */
public record AlumnoDTO(
        Long id,
        String nombre,
        String apellido,
        Integer estado,
        int edad
) {}
