package com.dfperu.scotiabank.ms_alumno.mapper;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import org.mapstruct.Mapper;

/**
 * Mapper que convierte entre {@link Alumno} (entidad) y {@link AlumnoDTO} (DTO).
 * Utiliza MapStruct para realizar el mapeo automático entre objetos.
 */
@Mapper(componentModel = "spring")
public interface AlumnoMapper {

    /**
     * Convierte una entidad {@link Alumno} a su representación {@link AlumnoDTO}.
     *
     * @param alumno entidad Alumno a convertir
     * @return objeto AlumnoDTO equivalente
     */
    AlumnoDTO toDTO(Alumno alumno);

    /**
     * Convierte un {@link AlumnoDTO} a su entidad {@link Alumno}.
     *
     * @param alumnoDTO objeto DTO a convertir
     * @return entidad Alumno equivalente
     */
    Alumno toEntity(AlumnoDTO alumnoDTO);
}
