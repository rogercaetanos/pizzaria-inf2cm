package com.itb.inf2cm.pizzaria.controller;

import com.itb.inf2cm.pizzaria.exceptions.BadRequest;
import com.itb.inf2cm.pizzaria.model.Categoria;
import com.itb.inf2cm.pizzaria.services.CategoriaService;
import com.itb.inf2cm.pizzaria.services.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//@Controller:       Exclusivo para sistemas WEB
//@RestController:   Exclusivo para APIS
//@RequestMapping:   Representa a url principal do controlador
//@GetMapping    :   Representa a url complementar do controlador. UTILIZADO EXCLUSIVAMENTE PARA "CONSULTAS"  SELECT
//@PostMapping    :  Representa a url complementar do controlador. UTILIZADO EXCLUSIVAMENTE PARA "CADASTROS" INSERT
//@PutMapping    :   Representa a url complementar do controlador. UTILIZADO EXCLUSIVAMENTE PARA "ATUALIZAR"  UPDATE
//@DeleteMapping   : Representa a url complementar do controlador. UTILIZADO EXCLUSIVAMENTE PARA "EXCLUIR"    DELETE
//@PathVariable  :   Representa os parâmetros (variáveis) passada(s) através da url

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

    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable(value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.listarCategoriaPorId(Long.parseLong(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 6.");
        }
    }

    @PostMapping("/categoria")
    @Transactional
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/funcionario/categoria").toUriString());

        return ResponseEntity.created(uri).body(categoriaService.salvarCategoria(categoria));
    }


    @PutMapping("/categoria/{id}")
    @Transactional
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable(value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.atualizarCategoria(categoria, Long.parseLong(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 6.");
        }

    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Object> deletarCategoria (@PathVariable(value = "id") String id) {

        try{
            if(categoriaService.deletarCategoria(Long.parseLong(id))) {
                return ResponseEntity.ok().body("Categoria com o id " + id + " excluída com sucesso");
            }
        } catch (NumberFormatException ex){
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 6.");
        }

        return ResponseEntity.ok().body("Não foi possível a exclusão da categoria com o id " + id);
    }


}
