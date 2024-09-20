package com.itb.inf2cm.pizzaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id    // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-incremento
    private Long id;

    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = true, length = 100)
    private String descricao;
    private boolean codStatus;

    // Atributos de apoio (validação)

    @Transient                     // NÃO REPRESENTA UMA COLUNA
    @JsonIgnore
    private String mensagemErro = "";
    @Transient                     // NÃO REPRESENTA UMA COLUNA
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCodStatus() {
        return codStatus;
    }

    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean validarCategoria() {
        if(nome == null || nome.isEmpty()) {
            mensagemErro += "O nome da categoria é obrigatório:";
            isValid = false;
        }
        return isValid;
    }
}
