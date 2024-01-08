package com.ocard.server.service.article;

import com.ocard.server.model.article.Article;
import com.ocard.server.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticle() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Integer articleId) {
        Optional<Article> articleResponse = articleRepository.findById(articleId);
        if (articleResponse.isPresent()) {
            return articleResponse.get();
        } else {
            throw new NoSuchElementException("Get method failed: ArticleId not found.");
        }
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Integer articleId, Article article) {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        if (articleExisting.isPresent()) {
            article.setArticleId(articleId);
            return articleRepository.save(article);
        } else {
            throw new NoSuchElementException("Update method failed: ArticleId not found.");
        }
    }

    @Override
    public String deleteArticle(Integer articleId) {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        if (articleExisting.isPresent()) {
            articleRepository.deleteById(articleId);
            return "Delete articleId success.";
        } else {
            throw new NoSuchElementException("Delete method failed: ArticleId not found.");
        }
    }
}
