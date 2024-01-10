package com.projeto.javasolutionshub.service;

import com.projeto.javasolutionshub.controller.dto.request.TopicRequest;
import com.projeto.javasolutionshub.controller.dto.response.TopicResponse;
import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Member;
import com.projeto.javasolutionshub.entity.Topic;
import com.projeto.javasolutionshub.repository.TopicRepository;
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

    @Autowired
    private MemberService memberService;

    public TopicResponse createTopic(TopicRequest topicRequest, Member mainMember) {
        Category category = categoryService.validateCategory(topicRequest.categoryId());
        Member member = memberService.getMember(mainMember.getUsername());

        Topic topic = new Topic(topicRequest, category, member);
        repository.save(topic);

        return new TopicResponse(topic);
    }

    public Page<TopicResponse> listTopics(Pageable pageable) {
        return repository.findAll(pageable).map(TopicResponse::new);
    }

    public TopicResponse updateTopic(Long id, TopicRequest topicRequest, Member mainMember) {
        Optional<Topic> topic = repository.findById(id);

        if (topic.get().getAuthor().getUsername().equals(mainMember.getUsername())) {
            Topic updateTopic = topic.get();
            Category category = categoryService.validateCategory(topicRequest.categoryId());
            updateTopic.setTitle(topicRequest.title());
            updateTopic.setMessage(topicRequest.message());
            updateTopic.setCategory(category);
            return new TopicResponse(updateTopic);
        }
        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED
        );
    }

}
