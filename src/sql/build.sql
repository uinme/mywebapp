CREATE DATABASE IF NOT EXISTS mywebapp_db;

USE mywebapp_db;

CREATE TABLE IF NOT EXISTS user (
  id                 INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username           VARCHAR(20)  ,
  email              VARCHAR(100) NOT NULL UNIQUE,
  encrypted_password VARCHAR(200) NOT NULL,
  created_at         DATETIME     NOT NULL,
  updated_at         DATETIME     NOT NULL
);
