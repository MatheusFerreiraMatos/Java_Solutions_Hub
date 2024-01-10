package com.projeto.javasolutionshub.controller.dto.request;

import com.projeto.javasolutionshub.entity.Category;
import com.projeto.javasolutionshub.entity.Member;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TopicRequest {

    @NotBlank @NotNull
    private String title;
    @NotBlank @NotNull
    private String message;
    @NotNull
    private Long categoryId;
    private Member author;

}
