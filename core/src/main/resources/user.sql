--CREATE DATABASE what;

CREATE TABLE user(
    id VARCHAR(128) NOT NULL,
    name VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    created_at BIGINT NOT NULL,
    primary key(id)
);
