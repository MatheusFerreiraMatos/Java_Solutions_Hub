package com.projeto.javasolutionshub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Collaboration {

    private Long id;
    private String message;
    @ManyToOne
    private Topic topic;
    private LocalDateTime creationDate;
    @ManyToOne
    private Member author;
    private boolean solution;

    public Collaboration(Long id, String message, Topic topic, LocalDateTime creationDate, Member author, boolean solution) {
        this.id = id;
        this.message = message;
        this.topic = topic;
        this.creationDate = creationDate = LocalDateTime.now();
        this.author = author;
        this.solution = false;
    }

}
