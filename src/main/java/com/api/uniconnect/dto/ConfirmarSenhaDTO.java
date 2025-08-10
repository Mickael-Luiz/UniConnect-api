package com.api.uniconnect.dto;

import com.api.uniconnect.enums.TiposEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfirmarSenhaDTO {

    @NotBlank(message = "Token é obrigatório.")
    private String token;
    @NotBlank(message = "Senha é obrigatório.")
    private String senha;
    private TiposEnum.TipoUsuario tipo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TiposEnum.TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TiposEnum.TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
