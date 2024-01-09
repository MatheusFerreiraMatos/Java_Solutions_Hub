package com.projeto.javasolutionshub.entity;

import com.projeto.javasolutionshub.model.TypeCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeCategory name;

}
