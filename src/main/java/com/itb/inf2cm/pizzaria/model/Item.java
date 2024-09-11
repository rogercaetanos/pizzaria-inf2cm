package com.itb.inf2cm.pizzaria.model;

public class Item {
    private Long id;
    private int quantidade;
    private boolean codStatusItem;

    // Atributos de apoio (validação)

    private String mensagemErro = "";
    private boolean isValid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isCodStatusItem() {
        return codStatusItem;
    }

    public void setCodStatusItem(boolean codStatusItem) {
        this.codStatusItem = codStatusItem;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public boolean validarItem() {

        return isValid;
    }


}
