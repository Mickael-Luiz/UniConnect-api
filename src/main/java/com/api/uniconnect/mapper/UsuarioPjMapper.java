package com.api.uniconnect.mapper;

import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioPjDTO;
import com.api.uniconnect.model.UsuarioPj;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioPjMapper {

    UsuarioPjMapper INSTANCE = Mappers.getMapper(UsuarioPjMapper.class);

    UsuarioPj toEntity(UsuarioCreateDTO.PessoaJuridica dto);

    UsuarioPjDTO toDTO(UsuarioPj usuarioPj);
}
