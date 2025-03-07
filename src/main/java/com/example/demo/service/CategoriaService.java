package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRpository;

import java.util.List;
import java.util.Optional;

public class CategoriaService {
    private CategoriaRpository repository = new CategoriaRpository();

    public Categoria criarCategoria(String nome, String descricao){
        Categoria novaCategoria = new Categoria(null,nome,descricao);
        return repository.adicionar(novaCategoria);
    }

    public List<Categoria> listarCategorias() {
        return repository.listarTodas();

    }

    public Optional<Categoria> buscarCategoria(Long id) {
        return repository.buscarPorId(id);

    }

    public boolean atualizarCategoria(Long id, String nome, String descricao) {
        Categoria categoriaAtualizada = new Categoria(id, nome, descricao);
        return repository.atualizar(id, categoriaAtualizada);
    }

    public boolean deletarCategoria(Long id) {
        return repository.remover(id);

    }
}
