DROP TABLE subcategory;
DROP TABLE category;

CREATE TABLE category(
                         category_id INT AUTO_INCREMENT PRIMARY KEY,
                         category_name VARCHAR(255) NOT NULL
);

CREATE TABLE subcategory (
                             subcategory_id INT AUTO_INCREMENT PRIMARY KEY,
                             subcategory_name VARCHAR(100) NOT NULL,
                             category_id INT NOT NULL,
                             FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE CASCADE
);


-- 插入 category 表格的数据
INSERT INTO category (category_name) VALUES ('感情生活');

-- 插入 subcategory 表格的数据
INSERT INTO subcategory (subcategory_name, category_id) VALUES
                                                            ('感情', 1),
                                                            ('閒聊', 1),
                                                            ('心情', 1),
                                                            ('結婚', 1),
                                                            ('親子', 1),
                                                            ('男孩', 1),
                                                            ('女孩', 1),
                                                            ('心理', 1);
