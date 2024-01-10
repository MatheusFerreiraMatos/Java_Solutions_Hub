package com.projeto.javasolutionshub.controller.dto.request;

import com.projeto.javasolutionshub.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TopicRequest {

    @NotBlank(message = "{validation.titleNotBlank}")
    @Size(min = 5, max = 100, message = "{validation.titleSize}")
    private String title;
    @NotBlank(message = "{validation.messageNotBlank}")
    @Size(max = 1000, message = "{validation.messageSize}")
    private String message;
    @NotNull(message = "{validation.categoryIdNotNull}")
    private Long categoryId;
    private Member author;

}
