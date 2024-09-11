package com.itb.inf2cm.pizzaria;

import com.itb.inf2cm.pizzaria.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzariaApplication.class, args);

		System.out.println("Meu primeiro projeto Spring Boot INF2CM ITB Jd.Belval");

		Produto p1 = new Produto();
		// p1.valorVenda = -56.00; Não temos mais acesso "modificador de acesso" agora é private
		p1.setValorVenda(-56.00);
		p1.setValorCompra(-10.00);
		p1.validarProduto();
		System.out.println("Valor de venda do produto: " + p1.getValorVenda() );
		System.out.println("Valor de compra do produto: " + p1.getValorCompra());
		System.out.println("Informações: \n" + p1.getMensagemErro());

	}

}
