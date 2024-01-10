package com.projeto.javasolutionshub.service;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
import com.projeto.javasolutionshub.controller.dto.response.TopicResponse;
import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Topic;
import com.projeto.javasolutionshub.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        Category category = categoryService.validateCategory(data.categoryId());

        Topic topic = new Topic(data, category);
        repository.save(topic);

        return new TopicResponse(topic);
    }

    public Page<TopicResponse> listTopics(Pageable pageable) {
        return repository.findAll(pageable).map(TopicResponse::new);
    }
}
