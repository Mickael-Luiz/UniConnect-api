package com.api.uniconnect.controller;

import com.api.uniconnect.services.UsuarioService;
import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioDTO;
import com.api.uniconnect.model.Usuario;
import com.api.uniconnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO criarUsuario(@RequestBody UsuarioCreateDTO dto) {
        return usuarioService.criarUsuario(dto);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Usuario> listUsuarios = usuarioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsuarios);
    }
}
