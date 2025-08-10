package com.api.uniconnect.controller;

import com.api.uniconnect.dto.ConfirmarSenhaDTO;
import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioPfDTO;
import com.api.uniconnect.dto.UsuarioPjDTO;
import com.api.uniconnect.services.PublicUsuarioService;
import com.api.uniconnect.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/public")
public class PublicUsuarioController {

    @Autowired
    PublicUsuarioService publicUsuarioService;

    @PostMapping("/usuario-pf")
    public UsuarioPfDTO criarUsuarioPF(@RequestBody UsuarioCreateDTO.PessoaFisica dto) {
        return publicUsuarioService.criarUsuarioPf(dto);
    }

    @PostMapping("/usuario-pj")
    public UsuarioPjDTO criarUsuarioPJ(@RequestBody UsuarioCreateDTO.PessoaJuridica dto) {
        return publicUsuarioService.criarUsuarioPj(dto);
    }

    @PostMapping("/usuario/confirmar-senha")
    public ResponseEntity<Void> confirmarSenha(@RequestBody ConfirmarSenhaDTO dto) {
        publicUsuarioService.confirmarSenha(dto);
        return ResponseEntity.ok().build();
    }
}
