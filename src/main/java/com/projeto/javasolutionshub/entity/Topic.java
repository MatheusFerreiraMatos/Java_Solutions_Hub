package com.projeto.javasolutionshub.entity;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
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
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    private Member author;
    @OneToMany(mappedBy = "topic")
    private List<Collaboration> responses;

    public Topic(TopicRequest data, Category category) {
        this.title = data.getTitle();
        this.message = data.getMessage();
        this.creationDate = LocalDateTime.now();
        this.status = StatusTopic.NOT_ANSWERED;
        this.category = category;
        this.author = data.getAuthor();
        this.responses = new ArrayList<>();
    }

}
