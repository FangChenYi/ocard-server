package com.ocard.server.service.article;

import com.ocard.server.model.article.Article;
import com.ocard.server.model.article.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();

    Article getArticleById(Integer articleId);

    Article createArticle(ArticleDTO articleDTO);

    Article updateArticle(Integer articleId, ArticleDTO articleDTO);

    String deleteArticle(Integer articleId);
}
