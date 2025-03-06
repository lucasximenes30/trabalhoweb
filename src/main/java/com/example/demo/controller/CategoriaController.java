package com.example.demo.controller;

import java.util.Optional;
import com.example.demo.dto.CategoriaDTO;
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service = new CategoriaService();

    @PostMapping
    public Categoria criarCategoria(@RequestBody CategoriaDTO dto){
        return service.criarCategoria(dto.getNome(), dto.getDescricao());
    }

    @GetMapping
    public List<Categoria> listarCategorias(){
        return service.listarCategorias();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarCategoria(@PathVariable Long id) {
        return service.buscarCategoria(id);
    }

    @PutMapping("/{id}")
    public boolean atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        return service.atualizarCategoria(id, dto.getNome(), dto.getDescricao());
    }
    @DeleteMapping("/{id}")
    public boolean deletarCategoria(@PathVariable Long id) {
        return service.deletarCategoria(id);
    }
}
