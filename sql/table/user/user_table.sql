CREATE TABLE user
(
    user_id          INT AUTO_INCREMENT PRIMARY KEY,
    username         VARCHAR(50) NOT NULL,
    email            VARCHAR(255) NOT NULL,
    password         VARCHAR(255) NOT NULL,
    registration_date DATETIME NOT NULL
);

INSERT INTO user (username, email, password, registration_date)
VALUES ('JohnDoe', 'johndoe@example.com', 'hashed_password', '2024-01-16');
