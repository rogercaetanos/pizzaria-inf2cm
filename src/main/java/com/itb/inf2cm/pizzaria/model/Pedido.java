package com.itb.inf2cm.pizzaria.model;

import java.time.LocalDateTime;

public class Pedido {

    private Long id;
    private LocalDateTime dataHoraCompra;
    private double valorPedido;
    private String status;
    private boolean codStatusPedido;

    // Atributos de apoio (validação)

    private String mensagemErro = "";
    private boolean isValid = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(LocalDateTime dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCodStatusPedido() {
        return codStatusPedido;
    }

    public void setCodStatusPedido(boolean codStatusPedido) {
        this.codStatusPedido = codStatusPedido;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

   public boolean validarPedido() {

        return isValid;
   }

}
