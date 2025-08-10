package com.api.uniconnect.model;

import com.api.uniconnect.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "usuarioPf")
@Table(name = "usuario_pf")
public class UsuarioPf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private String cpf;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnum.StatusUsuario status;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String contato1;

    private String contato2;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    @Column(name = "senha_hash")
    private String senhaHash;

    public UsuarioPf() {
    }

    public UsuarioPf(Integer id, String nome, String email, LocalDateTime dataCadastro, StatusEnum.StatusUsuario status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusEnum.StatusUsuario getStatus() {
        return status;
    }

    public void setStatus(StatusEnum.StatusUsuario status) {
        this.status = status;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getContato1() { return contato1; }

    public void setContato1(String contato1) { this.contato1 = contato1; }

    public String getContato2() { return contato2; }

    public void setContato2(String contato2) { this.contato2 = contato2; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }

    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getSenhaHash() { return senhaHash; }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
}
