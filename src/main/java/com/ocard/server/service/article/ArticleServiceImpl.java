package com.ocard.server.service.article;

import com.ocard.server.mapper.article.ArticleMapper;
import com.ocard.server.model.article.Article;
import com.ocard.server.model.article.ArticleDTO;
import com.ocard.server.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

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
    public Article createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.articleDTOtoArticle(articleDTO);
        article.setDatePublished(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Integer articleId, ArticleDTO articleDTO) {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        if (articleExisting.isPresent()) {
            Article article = articleMapper.articleDTOtoArticle(articleDTO);
            article.setArticleId(articleId);
            article.setDatePublished(articleExisting.get().getDatePublished());
            article.setDateUpdated(LocalDateTime.now());
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
