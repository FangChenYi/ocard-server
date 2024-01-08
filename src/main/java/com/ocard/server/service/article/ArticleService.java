package com.ocard.server.service.article;

import com.ocard.server.model.article.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();

    Article getArticleById(Integer articleId);

    Article createArticle(Article article);

    Article updateArticle(Integer articleId, Article article);

    String deleteArticle(Integer articleId);
}
