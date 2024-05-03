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
    public Article getArticleById(Integer articleId) throws NoSuchElementException {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        if (articleExisting.isPresent()) {
            return articleExisting.get();
        } else {
            throw new NoSuchElementException("No article found with id: " + articleId);
        }
    }


    @Override
    public Article createArticle(CreateArticleDTO createArticleDTO) {
        Article article = articleMapper.createArticleDTOtoArticle(createArticleDTO);
        article.setDatePosted(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Integer articleId,
                                 UpdateArticleDTO updateArticleDTO) throws NoSuchElementException {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        Article article = articleMapper.updateArticleDTOtoArticle(updateArticleDTO);
        article.setArticleId(articleId);
        article.setSubcategory(articleExisting.get().getSubcategory());
        article.setDatePosted(articleExisting.get().getDatePosted());
        article.setDateUpdated(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    public String deleteArticle(Integer articleId) throws NoSuchElementException {
        Optional<Article> articleExisting = articleRepository.findById(articleId);
        articleRepository.deleteById(articleExisting.get().getArticleId());
        return "Delete articleId success.";
    }
}
