package com.projeto.javasolutionshub.service;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
import com.projeto.javasolutionshub.controller.dto.response.TopicResponse;
import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Topic;
import com.projeto.javasolutionshub.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    @Autowired
    private CategoryService categoryService;

    public TopicResponse createTopic(TopicRequest data) {
        Category category = categoryService.validateCategory(data.getCategoryId());

        Topic topic = new Topic(data, category);
        repository.save(topic);

        return new TopicResponse(topic);
    }

}
