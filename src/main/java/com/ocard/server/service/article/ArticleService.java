package com.ocard.server.service.article;

import com.ocard.server.model.article.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();

    Object getArticleById(Integer articleId);

    Article createArticle(Article article);

    Object updateArticle(Integer articleId, Article article);

    String deleteArticle(Integer articleId);
}
