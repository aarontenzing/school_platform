CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    passwd VARCHAR(255),
    enabled TINYINT
);

CREATE TABLE authorities (
    username VARCHAR(50),
    authority VARCHAR(50),
    FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, passwd, enabled)
VALUES ('r001', '$2a$12$2njE8AeJ1snQVxZF3TH9v.x9aICsNWWNsfzNaKzDPGKLlLPZ5POA2', 1),
       ('d001', '$2a$12$Cln1sJPGv2v7DY67Cb6rzOAQWlF9dWDKToBVxbESByNQNoclEQWOq', 1);
       
INSERT INTO authorities (username, authority)
VALUES ('r001', 'ROLE_student'),
       ('d001', 'ROLE_docent');

commit;





