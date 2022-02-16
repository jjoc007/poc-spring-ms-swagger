CREATE TABLE person (
     id         INTEGER      NOT NULL AUTO_INCREMENT,
     name       VARCHAR(128) NOT NULL,
     last_name  VARCHAR(128) NOT NULL,
     phone      VARCHAR(128) NOT NULL,
     address    VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
);