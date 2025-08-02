package com.api.uniconnect.services;

import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioDTO;
import com.api.uniconnect.enums.StatusUsuario;
import com.api.uniconnect.mapper.UsuarioMapper;
import com.api.uniconnect.model.Usuario;
import com.api.uniconnect.model.UsuarioConfirmacao;
import com.api.uniconnect.repository.UsuarioConfirmacaoRepository;
import com.api.uniconnect.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PublicUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private UsuarioConfirmacaoRepository usuarioConfirmacaoRepository;


    public UsuarioDTO criarUsuario(UsuarioCreateDTO dto) {
        System.out.println("PublicUsuarioService está rodando!");
        Usuario usuario = usuarioMapper.toEntity(dto);
        usuario.setStatus(StatusUsuario.NAO_CONFIRMADO);
        usuario.setDataCadastro(LocalDate.now());
        usuario = usuarioRepository.save(usuario);

        String token = UUID.randomUUID().toString();
        UsuarioConfirmacao confirmacao = new UsuarioConfirmacao();
        confirmacao.setUsuario(usuario);
        confirmacao.setToken(token);
        confirmacao.setDataExpiracao(LocalDateTime.now().plusHours(1));
        usuarioConfirmacaoRepository.save(confirmacao);

        enviarEmailConfirmacao(usuario.getEmail(), token);
        return usuarioMapper.toDTO(usuario);
    }

    private void enviarEmailConfirmacao(String email, String token) {
        System.out.println("Enviar email para: " + email + "com link: http://localhost:4200/confirmar?token=" + token);
    }
}
