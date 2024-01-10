package com.projeto.javasolutionshub.controller.dto.response;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Collaboration;
import com.projeto.javasolutionshub.entity.Topic;
import com.projeto.javasolutionshub.model.StatusTopic;

import java.time.LocalDateTime;
import java.util.List;

public record TopicResponse(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        StatusTopic status,
        Category category,
        List<Collaboration> responses
) {
    public TopicResponse(Topic topic) {
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreationDate(),
                topic.getStatus(),
                topic.getCategory(),
                topic.getResponses()
        );
    }

}
