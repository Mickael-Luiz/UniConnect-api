package com.api.uniconnect.controller;

import com.api.uniconnect.model.Usuario;
import com.api.uniconnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity getAll() {
        List<Usuario> listUsuarios = usuarioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUsuarios);
    }
}
