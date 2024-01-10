package com.projeto.javasolutionshub.service;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.model.TypeCategory;
import com.projeto.javasolutionshub.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Optional<Category> validateCategory(Long categoryId) {
        return repository.findById(categoryId);
    }
}
