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
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MemberService memberService;

    public TopicResponse createTopic(TopicRequest data, Member mainMember) {
        Category category = categoryService.validateCategory(data.categoryId());
        Member member = memberService.getMember(mainMember.getUsername());

        Topic topic = new Topic(data, category, member);
        repository.save(topic);

        return new TopicResponse(topic);
    }

    public Page<TopicResponse> listTopics(Pageable pageable) {
        return repository.findAll(pageable).map(TopicResponse::new);
    }
}
