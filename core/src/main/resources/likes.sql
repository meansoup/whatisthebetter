--CREATE DATABASE what;

CREATE TABLE likes(
    liked_id VARCHAR(128) NOT NULL,
    user_id VARCHAR(128) NOT NULL,
    created_at BIGINT NOT NULL,
    primary key(liked_id, user_id)
);