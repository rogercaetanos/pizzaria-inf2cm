package com.itb.inf2cm.pizzaria.model;


import jakarta.persistence.*;

@Entity
@Table(name ="Telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String numero;
    private boolean codStatusUsuario;

    // Atributos de apoio (validação)

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

   public boolean validarTelefone() {

        return isValid;
   }

}
