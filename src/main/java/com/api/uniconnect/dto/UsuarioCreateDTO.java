package com.api.uniconnect.dto;

import lombok.*;

public class UsuarioCreateDTO {

    public static class PessoaFisica {

        private String nome;
        private String email;

        public PessoaFisica(){}

        public PessoaFisica(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class PessoaJuridica {

        private String email;
        private String cnpj;
        private String razaoSocial;

        public PessoaJuridica(){}

        public PessoaJuridica(String email, String cnpj, String razaoSocial) {
            this.email = email;
            this.cnpj = cnpj;
            this.razaoSocial = razaoSocial;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getRazaoSocial() {
            return razaoSocial;
        }

        public void setRazaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
        }
    }

}
