package com.projeto.javasolutionshub.entity;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
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

    public Topic(TopicRequest data, Category category, Member member) {
        this.title = data.title();
        this.message = data.message();
        this.creationDate = LocalDateTime.now();
        this.status = StatusTopic.NOT_ANSWERED;
        this.category = category;
        this.author = member;
        this.responses = new ArrayList<>();
    }

    public enum StatusTopic{
        NOT_ANSWERED,
        NOT_SOLVED,
        SOLVED,
        CLOSED;
    }

}
