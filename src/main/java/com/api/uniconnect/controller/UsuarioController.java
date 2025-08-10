package com.api.uniconnect.controller;

import com.api.uniconnect.model.UsuarioPf;
import com.api.uniconnect.repository.UsuarioPfRepository;
import com.api.uniconnect.services.UsuarioService;
import com.api.uniconnect.dto.UsuarioCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioPfRepository usuarioPfRepository;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity getAll() {
        List<UsuarioPf> listUsuarios = usuarioPfRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsuarios);
    }
}
