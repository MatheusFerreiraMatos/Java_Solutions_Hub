package com.projeto.javasolutionshub.controller.dto.request;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Member;
import lombok.Data;

@Data
public class TopicRequest {

    private String title;
    private String message;
    private Category category;
    private Member author;

}
