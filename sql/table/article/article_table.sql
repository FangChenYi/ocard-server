DROP TABLE article;

CREATE TABLE article
(
    article_id     INT AUTO_INCREMENT PRIMARY KEY,
    title          VARCHAR(255)  NOT NULL,
    content        TEXT          NOT NULL,
    comment_count  INT DEFAULT 0 NOT NULL,
    like_count     INT DEFAULT 0 NOT NULL,
    bookmark_count INT DEFAULT 0 NOT NULL,
    date_posted    DATETIME      NOT NULL,
    date_updated   DATETIME,
    subcategory_id INT           NOT NULL,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory (subcategory_id),
    user_id        INT           NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

INSERT INTO article (title, content, date_posted, subcategory_id, user_id)
VALUES ('如何處理分手後的情感挫折',
        '分手後的情感處理對每個人都很重要。有些技巧可以幫助你度過這段時期，比如專注於自我成長，尋找支持系統等。',
        '2023-12-20', 1, 1);
