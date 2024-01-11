INSERT INTO category (category_name)
VALUES ('感情生活');

INSERT INTO subcategory (subcategory_name, category_id)
VALUES ('感情', 1),
       ('閒聊', 1),
       ('心情', 1),
       ('結婚', 1),
       ('親子', 1),
       ('男孩', 1),
       ('女孩', 1),
       ('心理', 1);

INSERT INTO article (title, content, date_posted, subcategory_id)
VALUES ('如何處理分手後的情感挫折',
        '分手後的情感處理對每個人都很重要。有些技巧可以幫助你度過這段時期，比如專注於自我成長，尋找支持系統等。',
        '2023-12-20', 1);

INSERT INTO comment (comment_content, date_posted, article_id)
VALUES ('這是第一則評論', '2023-01-01', 1);