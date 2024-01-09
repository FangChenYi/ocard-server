package com.ocard.server.model.article;

import com.ocard.server.model.category.Subcategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private int commentCount;

    private int likeCount;

    private int bookmarkCount;

    private Subcategory subcategory;

}