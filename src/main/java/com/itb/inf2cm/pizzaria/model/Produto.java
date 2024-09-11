package com.itb.inf2cm.pizzaria.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    // Modificadores de acesso

    // public    -  Acesso livre para todas as classes
    // private   -  Acesso permitido "APENAS" dentro da própria classe
    // protected -  Acesso somente dentro das classes filhas ( Herança )

    // Encapsulamento
    // 1º Passo : Trabalhar com modificador de acesso private ou protected para os atributos
    // 2º Passo : Criar os métodos Setter´s e Getter´s
    // Obs: O método set -> serve para atribuir um valor ao atributo
    //      O método get -> serve para recuperar um valor do atributo
    // PARA CADA ATRIBUTO TEREMOS O SET E O GET CORRESPONDENTE, na maioria das situações.

    // 3º Passo: Enfim, criar os métodos de validação


    @Id                                                          // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)          // AUTO-INCREMENT
    private Long id;
    @Column(nullable = false, length = 45)   //  nullable = false -> NOT NULL
    private String nome;
    @Column(nullable = true, length = 45)
    private String tipo;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double valorCompra;
    @Column(nullable = true, columnDefinition = "DECIMAL(5,2)")
    private double valorVenda;
    private boolean codStatus;

    @Column(nullable = true, length = 100)
    private String descricao;

    @Column(nullable = true)
    private int quantidadeEstoque;

    // Atributos de apoio (validação)

    @Transient                           // Atributo que NÃO É COLUNA
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;


    public void setId(Long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(double valorCompra) {

        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {

        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {

        this.valorVenda = valorVenda;
    }

    public boolean isCodStatus() {

        return codStatus;
    }

    public void setCodStatus(boolean codStatus) {

        this.codStatus = codStatus;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {

        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {

        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }



    // Método para validar o produto

    public boolean validarProduto() {

        if(valorVenda < 0){
            isValid = false;
            valorVenda = 0;
            mensagemErro += "O valor de venda do produto não pode ser menor que zero!\n";
        }
        if(valorCompra< 0){
            isValid = false;
            valorCompra = 0;
            mensagemErro += "O valor de compra do produto não pode ser menor que zero!\n";
        }
        return isValid;
    }

}
