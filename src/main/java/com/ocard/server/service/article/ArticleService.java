package com.ocard.server.service.article;

import com.ocard.server.dto.article.CreateArticleDTO;
import com.ocard.server.dto.article.UpdateArticleDTO;
import com.ocard.server.model.article.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();

    Article getArticleById(Integer articleId);

    Article createArticle(CreateArticleDTO createArticleDTO);

    Article updateArticle(Integer articleId, UpdateArticleDTO updateArticleDTO);

    String deleteArticle(Integer articleId);
}
