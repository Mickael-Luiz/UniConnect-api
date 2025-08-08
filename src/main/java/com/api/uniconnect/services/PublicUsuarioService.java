package com.api.uniconnect.services;

import com.api.uniconnect.dto.ConfirmarSenhaDTO;
import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioDTO;
import com.api.uniconnect.enums.StatusUsuario;
import com.api.uniconnect.exception.EmailException;
import com.api.uniconnect.mapper.UsuarioMapper;
import com.api.uniconnect.model.Usuario;
import com.api.uniconnect.model.UsuarioConfirmacao;
import com.api.uniconnect.repository.UsuarioConfirmacaoRepository;
import com.api.uniconnect.repository.UsuarioRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UsuarioDTO criarUsuario(UsuarioCreateDTO dto) {
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

        try {
            emailService.enviarEmailConfirmacaoHtml(usuario.getEmail(), token);
        } catch (MessagingException e) {
            throw new EmailException("Erro ao enviar email de confirmação", e);
        }
        return usuarioMapper.toDTO(usuario);
    }

    public void confirmarSenha(ConfirmarSenhaDTO dto) {
        UsuarioConfirmacao usuarioConfirmacao = usuarioConfirmacaoRepository.findByToken(dto.getToken())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token Inválido"));
        if(usuarioConfirmacao.getDataExpiracao().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token Expirado");
        }

        Usuario usuario = usuarioConfirmacao.getUsuario();

        usuario.setSenhaHash(passwordEncoder.encode(dto.getSenha()));
        usuario.setStatus(StatusUsuario.ATIVO);
        usuarioRepository.save(usuario);
        usuarioConfirmacaoRepository.delete(usuarioConfirmacao);
    }

}
