package com.itb.inf2cm.pizzaria.services;


import com.itb.inf2cm.pizzaria.exceptions.BadRequest;

import com.itb.inf2cm.pizzaria.exceptions.NotFound;
import com.itb.inf2cm.pizzaria.model.Produto;
import com.itb.inf2cm.pizzaria.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    // final : Atributo que foi atribuído não pode ser alterado.
    private final ProdutoRepository produtoRepository;

    // Injeção de dependência utilizando o construtor da classe

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto salvarProduto(Produto produto) {
        produto.setCodStatus(true);
        if(!produto.validarProduto()){
            throw new BadRequest(produto.getMensagemErro());
        }
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public boolean deletarProduto(Long id) {
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        } else {
          throw new NotFound("Produto não encontrado com o id " + id);
        }
        return true;
    }

    // try    :  Tente realizar a tarefa
    // catch  :  Execute caso a realização da tarefa "falhar"
    @Override
    public Produto listarProdutoPorId(Long id) {
       try{
           return produtoRepository.findById(id).get();
       }catch(Exception ex) {
           throw new NotFound("Produto não encontrado com o id " + id);
       }
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    @Transactional
    public Produto atualizarProduto(Produto produto, Long id) {
        return null;
    }
}
