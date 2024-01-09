package com.projeto.javasolutionshub.controller;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
import com.projeto.javasolutionshub.controller.dto.response.TopicResponse;
import com.projeto.javasolutionshub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    public ResponseEntity register(@RequestBody@Valid TopicRequest topicRequest, UriComponentsBuilder uriBuilder) {
        TopicResponse topicResponse = service.createTopic(topicRequest);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topicResponse.getId()).toUri();

        return ResponseEntity.created(uri).body(topicResponse);
    }
}
