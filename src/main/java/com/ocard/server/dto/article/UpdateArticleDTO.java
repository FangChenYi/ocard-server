package com.ocard.server.dto.article;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateArticleDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
