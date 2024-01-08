package com.ocard.server.controller.article;

import com.ocard.server.model.article.Article;
import com.ocard.server.service.article.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public List<Article> getAllArticle(){
        return articleService.getAllArticle();
    }

    @GetMapping("/article/{articleId}")
    public Article getArticleById(@PathVariable Integer articleId) {
        return articleService.getArticleById(articleId);
    }

    @PostMapping("/article")
    public Article createArticle(@RequestBody @Valid Article article){
        return articleService.createArticle(article);
    }

    @PutMapping("/article/{articleId}")
    public Article updateArticle(@PathVariable Integer articleId,
                                 @RequestBody @Valid Article article) {
        return articleService.updateArticle(articleId, article);
    }

    @DeleteMapping("/article/{articleId}")
    public String deleteArticle(@PathVariable Integer articleId) {
        return articleService.deleteArticle(articleId);
    }
}
