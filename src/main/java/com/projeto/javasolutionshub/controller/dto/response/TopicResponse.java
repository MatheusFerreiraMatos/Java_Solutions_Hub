package com.projeto.javasolutionshub.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.javasolutionshub.entity.Collaboration;
import com.projeto.javasolutionshub.entity.Topic;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponse(
        Long id,
        String title,
        String message,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime creationDate,
        String status,
        String author,
        String nameCategory,
        List<Collaboration> responses
) {
    public TopicResponse(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                String.valueOf(topic.getStatus()),
                topic.getAuthor().getFirstName(),
                topic.getCategory().getName(),
                topic.getResponses()
        );
    }

}
