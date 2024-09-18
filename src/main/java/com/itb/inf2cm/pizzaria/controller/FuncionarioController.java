package com.itb.inf2cm.pizzaria.controller;

import com.itb.inf2cm.pizzaria.model.Categoria;
import com.itb.inf2cm.pizzaria.services.CategoriaService;
import com.itb.inf2cm.pizzaria.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller:       Exclusivo para sistemas WEB
//@RestController:   Exclusivo para APIS
//@RequestMapping:   Representa a url principal do controlador
//@GetMapping    :   Representa a url complementar do controlador. UTILIZADO EXCLUSIVAMENTE PARA "CONSULTAS"

@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncionarioController {

    private final CategoriaService categoriaService;
    private final ProdutoService produtoService;

    public FuncionarioController(CategoriaService categoriaService, ProdutoService produtoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {
        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }



}
