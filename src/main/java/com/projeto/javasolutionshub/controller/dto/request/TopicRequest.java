package com.projeto.javasolutionshub.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TopicRequest(
        @NotBlank(message = "{validation.titleNotBlank}")
        @Size(min = 5, max = 100, message = "{validation.titleSize}")
        String title,
        @NotBlank(message="{validation.messageNotBlank}")
        @Size(max = 1000, message = "{validation.messageSize}")
        String message,
        @NotNull(message = "{validation.categoryIdNotNull}")
        Long categoryId
) {}
