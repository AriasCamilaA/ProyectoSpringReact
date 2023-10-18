package com.api.services;

import com.api.models.CategoriaModel;
import com.api.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaService {
    @Autowired
    public CategoriaRepository categoriaRepository;
    public CategoriaModel createCategoria(CategoriaModel categoria){
        categoria.setEstado(true);
        return categoriaRepository.save(categoria);
    }
    public CategoriaModel getCategoriaById(Integer id){
        Optional<CategoriaModel> optionalCategoria = categoriaRepository.findById(id);
        return optionalCategoria.get();
    }

    public List<CategoriaModel> getAllCategoria() {
        return categoriaRepository.findAll();
    }

    public void deleteCategoriaById(Integer id){
        categoriaRepository.deleteById(id);
    }
}
