package com.ocard.server.service.article;

import com.ocard.server.dto.article.CreateArticleDTO;
import com.ocard.server.dto.article.UpdateArticleDTO;
import com.ocard.server.mapper.article.ArticleMapper;
import com.ocard.server.model.article.Article;
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
    public Article createArticle(CreateArticleDTO createArticleDTO) {
        Article article = articleMapper.CreateArticleDTOtoArticle(createArticleDTO);
        article.setDatePublished(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Integer articleId, UpdateArticleDTO updateArticleDTO) {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        if (articleExisting.isPresent()) {
            Article article = articleMapper.UpdateArticleDTOtoArticle(updateArticleDTO);
            article.setArticleId(articleId);
            article.setSubcategory(articleExisting.get().getSubcategory());
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
