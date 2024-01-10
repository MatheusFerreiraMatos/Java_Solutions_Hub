package com.projeto.javasolutionshub.controller;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
import com.projeto.javasolutionshub.controller.dto.response.TopicResponse;
import com.projeto.javasolutionshub.entity.Member;
import com.projeto.javasolutionshub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    public ResponseEntity register(@RequestBody@Valid TopicRequest topicRequest,
                                   @AuthenticationPrincipal Member member,
                                   UriComponentsBuilder uriBuilder) {
        System.out.println("Usuário sessão:   " + member);
        TopicResponse topicResponse = service.createTopic(topicRequest, member);

        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topicResponse.id()).toUri();

        return ResponseEntity.created(uri).body(topicResponse);
    }

    @GetMapping
    public ResponseEntity<Page<TopicResponse>> list(
            @PageableDefault(size = 10, sort = {"creationDate"}) Pageable pageable) {
        var page = service.listTopics(pageable);
        return ResponseEntity.ok(page);
    }
}
