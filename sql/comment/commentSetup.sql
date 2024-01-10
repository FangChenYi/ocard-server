DROP TABLE comment;

CREATE TABLE comment
(
    comment_id      INT AUTO_INCREMENT PRIMARY KEY,
    comment_content TEXT     NOT NULL,
    date_posted     DATETIME NOT NULL,
    date_updated    DATETIME,
    article_id      INT      NOT NULL,
    FOREIGN KEY (article_id) REFERENCES article (article_id) ON DELETE CASCADE
);

INSERT INTO comment (comment_content, date_posted, article_id)
VALUES ('這是第一則評論', '2023-01-01', 1)