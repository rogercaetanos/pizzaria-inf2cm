package com.itb.inf2cm.pizzaria.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true, length = 45)
    private String nome;
    @Column(nullable = true, length = 45)
    private String tipoUsuario;
    @Column(nullable = true, length = 20)
    private String cpf;
    @Column(nullable = false, length = 45)
    private String email;
    @Column(nullable = false, length = 255)
    private String senha;
    @Column(nullable = true, length = 12)
    private String cep;
    @Column(nullable = true, length = 100)
    private String logradouro;
    @Column(nullable = true, length = 45)
    private String bairro;
    @Column(nullable = true, length = 45)
    private String cidade;
    @Column(nullable = true, length = 2)
    private String uf;
    private boolean codStatusUsuario;

    // Mensagem de apoio

    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public boolean isCodStatusUsuario() {
        return codStatusUsuario;
    }

    public void setCodStatusUsuario(boolean codStatusUsuario) {
        this.codStatusUsuario = codStatusUsuario;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }


    public boolean validarUsuario() {

        return isValid;
    }


}
