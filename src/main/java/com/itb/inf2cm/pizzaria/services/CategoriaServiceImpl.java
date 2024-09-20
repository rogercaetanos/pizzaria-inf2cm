package com.itb.inf2cm.pizzaria.services;

import com.itb.inf2cm.pizzaria.exceptions.BadRequest;
import com.itb.inf2cm.pizzaria.exceptions.NotFound;
import com.itb.inf2cm.pizzaria.model.Categoria;
import com.itb.inf2cm.pizzaria.model.Produto;
import com.itb.inf2cm.pizzaria.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{


    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    @Override
    @Transactional
    public Categoria salvarCategoria(Categoria categoria) {
        categoria.setCodStatus(true);
        if(!categoria.validarCategoria()){
            throw new BadRequest(categoria.getMensagemErro());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public boolean deletarCategoria(Long id) {
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        } else {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
        return true;
    }

    @Override
    public Categoria listarCategoriaPorId(Long id) {
        try{
            return categoriaRepository.findById(id).get();
        }catch(Exception ex) {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }

    @Override
    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria atualizarCategoria(Categoria categoria, Long id) {
        try{
            if(!categoria.validarCategoria()) {
                throw new BadRequest(categoria.getMensagemErro());
            }
            // Prosseguindo na atualização
            Categoria categoriaBd = categoriaRepository.findById(id).get();
            categoriaBd.setNome(categoria.getNome());
            categoriaBd.setDescricao(categoria.getDescricao());
            return categoriaRepository.save(categoriaBd); // save: Atualiza quando já existe o objeto no banco de dados
        }catch (Exception ex){
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }
}
