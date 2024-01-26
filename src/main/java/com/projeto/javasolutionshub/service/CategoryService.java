package com.projeto.javasolutionshub.service;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category validateCategory(Long categoryId) {
        return repository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada."));
    }

}
