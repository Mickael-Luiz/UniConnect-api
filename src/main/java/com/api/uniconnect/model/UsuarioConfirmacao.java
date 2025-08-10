package com.api.uniconnect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "usuario_confirmacao")
public class UsuarioConfirmacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "usuario_pf_id", nullable = false)
    private UsuarioPf usuarioPf;

    @OneToOne
    @JoinColumn(name = "usuario_pj_id", nullable = false)
    private UsuarioPj usuarioPj;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(name = "data_expiracao", nullable = false)
    private LocalDateTime dataExpiracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioPf getUsuarioPf() {
        return usuarioPf;
    }

    public void setUsuarioPf(UsuarioPf usuarioPf) {
        this.usuarioPf = usuarioPf;
    }

    public UsuarioPj getUsuarioPj() {
        return usuarioPj;
    }

    public void setUsuarioPj(UsuarioPj usuarioPj) {
        this.usuarioPj = usuarioPj;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
