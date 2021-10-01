CREATE TABLE IF NOT EXISTS articles
(
    id BIGSERIAL  PRIMARY KEY ,
    author varchar(255),
    content text,
    publication_date date,
    title varchar(255)
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL  PRIMARY KEY ,
    password varchar(255),
    user_type varchar(255),
    username varchar(255)
);