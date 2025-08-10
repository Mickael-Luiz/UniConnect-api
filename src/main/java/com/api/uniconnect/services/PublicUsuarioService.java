package com.api.uniconnect.services;

import com.api.uniconnect.dto.ConfirmarSenhaDTO;
import com.api.uniconnect.dto.UsuarioPfDTO;
import com.api.uniconnect.dto.UsuarioCreateDTO;
import com.api.uniconnect.dto.UsuarioPjDTO;
import com.api.uniconnect.enums.StatusEnum;
import com.api.uniconnect.enums.TiposEnum;
import com.api.uniconnect.exception.EmailException;
import com.api.uniconnect.mapper.UsuarioPfMapper;
import com.api.uniconnect.mapper.UsuarioPjMapper;
import com.api.uniconnect.model.UsuarioConfirmacao;
import com.api.uniconnect.model.UsuarioPf;
import com.api.uniconnect.model.UsuarioPj;
import com.api.uniconnect.repository.UsuarioConfirmacaoRepository;
import com.api.uniconnect.repository.UsuarioPfRepository;
import com.api.uniconnect.repository.UsuarioPjRepository;
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
    private UsuarioPfRepository usuarioPfRepository;
    @Autowired
    private UsuarioPjRepository usuarioPjRepository;
    @Autowired
    private UsuarioPfMapper usuarioPfMapper;
    @Autowired
    private UsuarioPjMapper usuarioPjMapper;
    @Autowired
    private UsuarioConfirmacaoRepository usuarioConfirmacaoRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UsuarioPfDTO criarUsuarioPf(UsuarioCreateDTO.PessoaFisica dto) {
        UsuarioPf usuario = usuarioPfMapper.toEntity(dto);
        usuario.setStatus(StatusEnum.StatusUsuario.NAO_CONFIRMADO);
        usuario.setDataCadastro(LocalDateTime.now());
        usuario = usuarioPfRepository.save(usuario);

        String token = UUID.randomUUID().toString();
        UsuarioConfirmacao confirmacao = new UsuarioConfirmacao();
        confirmacao.setUsuarioPf(usuario);
        confirmacao.setToken(token);
        confirmacao.setDataExpiracao(LocalDateTime.now().plusHours(1));
        usuarioConfirmacaoRepository.save(confirmacao);

        try {
            emailService.enviarEmailConfirmacaoHtml(usuario.getEmail(), token, TiposEnum.TipoUsuario.PF);
        } catch (MessagingException e) {
            throw new EmailException("Erro ao enviar email de confirmação", e);
        }
        return usuarioPfMapper.toDTO(usuario);
    }

    public UsuarioPjDTO criarUsuarioPj(UsuarioCreateDTO.PessoaJuridica dto) {
        UsuarioPj usuario = usuarioPjMapper.toEntity(dto);
        usuario.setStatus(StatusEnum.StatusUsuario.NAO_CONFIRMADO);
        usuario.setDataCadastro(LocalDateTime.now());
        usuario = usuarioPjRepository.save(usuario);

        String token = UUID.randomUUID().toString();
        UsuarioConfirmacao confirmacao = new UsuarioConfirmacao();
        confirmacao.setUsuarioPj(usuario);
        confirmacao.setToken(token);
        confirmacao.setDataExpiracao(LocalDateTime.now().plusHours(1));
        usuarioConfirmacaoRepository.save(confirmacao);

        try {
            emailService.enviarEmailConfirmacaoHtml(usuario.getEmail(), token, TiposEnum.TipoUsuario.PJ);
        } catch (MessagingException e) {
            throw new EmailException("Erro ao enviar email de confirmação", e);
        }
        return usuarioPjMapper.toDTO(usuario);
    }

    public void confirmarSenha(ConfirmarSenhaDTO dto) {
        UsuarioConfirmacao usuarioConfirmacao = usuarioConfirmacaoRepository.findByToken(dto.getToken())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token Inválido"));
        if (usuarioConfirmacao.getDataExpiracao().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token Expirado");
        }
        if (dto.getTipo().equals(TiposEnum.TipoUsuario.PF)) {
            UsuarioPf usuario = usuarioConfirmacao.getUsuarioPf();
            usuario.setSenhaHash(passwordEncoder.encode(dto.getSenha()));
            usuario.setStatus(StatusEnum.StatusUsuario.ATIVO);
            usuarioPfRepository.save(usuario);
        }
        if(dto.getTipo().equals(TiposEnum.TipoUsuario.PJ)){
            UsuarioPj usuario = usuarioConfirmacao.getUsuarioPj();
            usuario.setSenhaHash(passwordEncoder.encode(dto.getSenha()));
            usuario.setStatus(StatusEnum.StatusUsuario.ATIVO);
            usuarioPjRepository.save(usuario);
        }
        usuarioConfirmacaoRepository.delete(usuarioConfirmacao);
    }

}
