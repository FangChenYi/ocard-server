package com.ocard.server.repository.article;

import com.ocard.server.model.article.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
