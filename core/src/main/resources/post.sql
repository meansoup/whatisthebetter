--CREATE DATABASE what;

CREATE TABLE post(
    id VARCHAR(128) NOT NULL,
    user_id VARCHAR(128) NOT NULL,
    title TEXT NOT NULL,

    content1_title TEXT NOT NULL,
    content1_description MEDIUMTEXT NOT NULL,

    content2_title TEXT NOT NULL,
    content2_description MEDIUMTEXT NOT NULL,

    created_at BIGINT NOT NULL,
    modified_at BIGINT NOT NULL,
    primary key(id)
);