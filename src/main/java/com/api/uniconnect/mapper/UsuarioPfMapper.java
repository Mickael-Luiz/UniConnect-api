package com.api.uniconnect.mapper;

import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioPfDTO;
import com.api.uniconnect.model.UsuarioPf;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioPfMapper {
    UsuarioPfMapper INSTANCE = Mappers.getMapper(UsuarioPfMapper.class);

    UsuarioPf toEntity(UsuarioCreateDTO.PessoaFisica dto);

    UsuarioPfDTO toDTO(UsuarioPf usuarioPf);
}
