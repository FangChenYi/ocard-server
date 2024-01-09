package com.ocard.server.mapper.article;

import com.ocard.server.model.article.Article;
import com.ocard.server.model.article.ArticleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article articleDTOtoArticle(ArticleDTO articleDTO);
}
