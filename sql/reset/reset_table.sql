DROP TABLE comment;
DROP TABLE article;
DROP TABLE user;
DROP TABLE subcategory;
DROP TABLE category;


CREATE TABLE category
(
    category_id   INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE subcategory
(
    subcategory_id   INT AUTO_INCREMENT PRIMARY KEY,
    subcategory_name VARCHAR(100) NOT NULL,
    category_id      INT          NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE
);

CREATE TABLE user
(
    user_id           INT AUTO_INCREMENT PRIMARY KEY,
    username          VARCHAR(50)  NOT NULL,
    email             VARCHAR(255) NOT NULL,
    password          VARCHAR(255) NOT NULL,
    registration_date DATETIME     NOT NULL
);

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

CREATE TABLE comment
(
    comment_id      INT AUTO_INCREMENT PRIMARY KEY,
    comment_content TEXT     NOT NULL,
    date_posted     DATETIME NOT NULL,
    date_updated    DATETIME,
    article_id      INT      NOT NULL,
    FOREIGN KEY (article_id) REFERENCES article (article_id) ON DELETE CASCADE
);

CREATE TRIGGER update_comment_count
    AFTER INSERT
    ON comment
    FOR EACH ROW
BEGIN
    UPDATE article
    SET comment_count = comment_count + 1
    WHERE article_id = NEW.article_id;
END;

CREATE TRIGGER delete_comment_count
    AFTER DELETE
    ON comment
    FOR EACH ROW
BEGIN
    UPDATE article
    SET comment_count = comment_count - 1
    WHERE article_id = OLD.article_id;
END;

