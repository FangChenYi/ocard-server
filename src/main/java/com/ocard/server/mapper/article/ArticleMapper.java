package com.ocard.server.mapper.article;

import com.ocard.server.dto.article.UpdateArticleDTO;
import com.ocard.server.model.article.Article;
import com.ocard.server.dto.article.CreateArticleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article CreateArticleDTOtoArticle(CreateArticleDTO createArticleDTO);
    Article UpdateArticleDTOtoArticle(UpdateArticleDTO updateArticleDTO);
}
