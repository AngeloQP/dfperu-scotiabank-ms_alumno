package com.dfperu.scotiabank.ms_alumno.mapper;

import com.dfperu.scotiabank.ms_alumno.model.dao.AlumnoDTO;
import com.dfperu.scotiabank.ms_alumno.model.entity.Alumno;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoDTO toDTO(Alumno alumno);
    Alumno toEntity(AlumnoDTO alumnoDTO);
}
