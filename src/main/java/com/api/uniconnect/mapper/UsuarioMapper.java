package com.api.uniconnect.mapper;

import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioDTO;
import com.api.uniconnect.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioCreateDTO dto);

    UsuarioDTO toDTO(Usuario usuario);
}
