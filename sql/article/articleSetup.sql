DROP TABLE article;
CREATE TABLE article (
                         article_id INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         content TEXT NOT NULL,
                         comment_count INT,
                         like_count INT,
                         bookmark_count INT,
                         date_published DATETIME NOT NULL,
                         date_updated DATETIME,
                         subcategory_id INT NOT NULL,
                         FOREIGN KEY (subcategory_id) REFERENCES subcategory(subcategory_id)
);

INSERT INTO article (title, content, comment_count, like_count, bookmark_count, date_published, subcategory_id)
VALUES
    ('如何處理分手後的情感挫折', '分手後的情感處理對每個人都很重要。有些技巧可以幫助你度過這段時期，比如專注於自我成長，尋找支持系統等。', 15, 120, 45, '2023-12-20', 1);
