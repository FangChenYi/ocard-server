package com.ocard.server.dto.article;

import com.ocard.server.model.category.Subcategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArticleDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Subcategory subcategory;

}