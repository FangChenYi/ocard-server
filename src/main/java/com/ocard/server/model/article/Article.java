package com.ocard.server.model.article;

import com.ocard.server.model.category.Subcategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;

    @NotBlank
    @Column(name = "title")
    private String title;

    @NotBlank
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "comment_count")
    private int commentCount;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "bookmark_count")
    private int bookmarkCount;

    @Column(name = "date_published", nullable = false)
    private Date datePublished;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

}
