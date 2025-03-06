package com.example.demo.repository;

import com.example.demo.model.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaRpository {
    private List<Categoria> categorias = new ArrayList<>();
    private Long proximoId = 1L;

    public Categoria adicionar(Categoria categoria) {
        categoria.setId(proximoId);
        categorias.add(categoria);
        return categoria;
    }

    public List<Categoria> listarTodas(){
        return categorias;
    }

    public Optional<Categoria> buscarPorId(Long id){
        return categorias.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public boolean atualizar(Long id, Categoria catedoriaAtualizar){
        Optional<Categoria> categoriaExistente = buscarPorId(id);
        if(categoriaExistente.isPresent()){
            Categoria c = categoriaExistente.get();
            c.setNome(catedoriaAtualizar.getNome());
            c.setDescricao(catedoriaAtualizar.getDescricao());
            return true;
        }
        return false;
    }

    public boolean remover(long id){
        return categorias.removeIf(c -> c.getId().equals(id));
    }
}
