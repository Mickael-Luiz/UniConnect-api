package com.api.uniconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UsuarioPjDTO {

    private Integer id;
    private String cnpj;
    private String email;
    private String razaoSocial;

    public UsuarioPjDTO(){}

    public UsuarioPjDTO(Integer id, String cnpj, String email, String razaoSocial) {
        this.id = id;
        this.cnpj = cnpj;
        this.email = email;
        this.razaoSocial = razaoSocial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
