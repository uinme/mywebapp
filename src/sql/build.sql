CREATE DATABASE IF NOT EXISTS mywebapp_db;

USE mywebapp_db;

CREATE TABLE IF NOT EXISTS user (
  id                 INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username           VARCHAR(20)  ,
  email              VARCHAR(100) NOT NULL UNIQUE,
  encrypted_password VARCHAR(200) NOT NULL,
  created_at         DATETIME     NOT NULL,
  updated_at         DATETIME     NOT NULL,
  INDEX id_index (id)
);

CREATE TABLE IF NOT EXISTS tweet (
  id         INT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id    INT      NOT NULL ,
  content    TEXT              ,
  created_at DATETIME NOT NULL ,
  updated_at DATETIME NOT NULL ,
  INDEX id_index (id)          ,
  FOREIGN KEY user_id_foreign (user_id) REFERENCES user (id)
);

CREATE TABLE IF NOT EXISTS follow (
  id INT NOT NULL AUTO_INCREMENT,
  follower_user_id INT NOT NULL,
  followed_user_id INT NOT NULL,
  INDEX id_index (id),
  PRIMARY KEY (id),
  FOREIGN KEY (follower_user_id) REFERENCES user (id),
  FOREIGN KEY (followed_user_id) REFERENCES user (id)
);
