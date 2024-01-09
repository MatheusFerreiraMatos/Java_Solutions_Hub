package com.projeto.javasolutionshub.controller.dto.response;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Collaboration;
import com.projeto.javasolutionshub.entity.Member;
import com.projeto.javasolutionshub.entity.Topic;
import com.projeto.javasolutionshub.model.StatusTopic;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TopicResponse {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private StatusTopic status;
    private Category category;
    private Member author;
    private List<Collaboration> responses;

    public TopicResponse(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();
        this.status = topic.getStatus();
        this.category = topic.getCategory();
        this.author = topic.getAuthor();
        this.responses = topic.getResponses();
    }

}
