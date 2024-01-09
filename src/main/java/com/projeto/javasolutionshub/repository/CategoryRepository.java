package com.projeto.javasolutionshub.repository;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.model.TypeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(TypeCategory name);
}
