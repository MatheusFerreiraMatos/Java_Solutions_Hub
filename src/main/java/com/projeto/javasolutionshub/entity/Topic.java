package com.projeto.javasolutionshub.entity;

import com.projeto.javasolutionshub.model.StatusTopic;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    @Enumerated(EnumType.STRING)
    private StatusTopic status;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Member author;
    @OneToMany(mappedBy = "topic")
    private List<Collaboration> responses;

    public Topic(Long id, String title, String message, LocalDateTime creationDate, StatusTopic status, Category category, Member author, List<Collaboration> responses) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.creationDate = LocalDateTime.now();
        this.status = StatusTopic.NOT_ANSWERED;
        this.category = category;
        this.author = author;
        this.responses = new ArrayList<>();
    }

}
