package com.api.uniconnect.controller;

import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioDTO;
import com.api.uniconnect.services.PublicUsuarioService;
import com.api.uniconnect.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/usuario")
public class PublicUsuarioController {

    @Autowired
    PublicUsuarioService publicUsuarioService;

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody UsuarioCreateDTO dto) {
        return publicUsuarioService.criarUsuario(dto);
    }
}
