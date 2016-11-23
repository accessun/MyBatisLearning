# This SQL script is used for database initialization for MySQL RDBMS
# MAKE SURE YOU DO NOT HAVE A DATABASE NAMED `mybatisdemo` with useful data stored in it

## initialize database
DROP DATABASE IF EXISTS mybatisdemo;

CREATE DATABASE mybatisdemo
CHARSET 'utf8'
COLLATE 'utf8_general_ci';

## initialize tables
USE mybatisdemo;

DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  dept_name VARCHAR (30) NOT NULL,
  location VARCHAR (30),
  manager_id INT UNSIGNED,
  PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

CREATE TABLE employees (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(30) NOT NULL,
    gender ENUM('female', 'male'),
    age INT(3) UNSIGNED,
    email VARCHAR(50),
    salary INT(8) UNSIGNED,
    date_of_birth DATE,
    dept_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (dept_id) REFERENCES departments(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE AUTHORS (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(50),
    email VARCHAR(30),
    bio VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE blogs (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    author_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES AUTHORS(id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


## inert test data

INSERT INTO departments (
  dept_name,
  location,
  manager_id
) 
VALUES
  ('IT', 'Seattle', 4),
  ('Accounting', 'Seattle', 5),
  ('PR', 'New York', 1),
  ('HR', 'New York', 6),
  ('Marketing', 'New York', 2),
  ('Support', 'Seattle', 3);


INSERT INTO employees (
  NAME,
  gender,
  salary,
  age,
  email,
  date_of_birth,
  dept_id
) 
VALUES
  (
    'Adam Smith',
    'male',
    8000,
    20,
    'adam-smith_37ec3@example.com',
    STR_TO_DATE('1985-08-08', '%Y-%m-%d'),
    6
  ),
  (
    'Robert Allen',
    'male',
    7000,
    22,
    'robert-allen_200ef@example.com',
    STR_TO_DATE('1982-08-08', '%Y-%m-%d'),
    3
  ),
  (
    'Carol Morris',
    'female',
    10000,
    26,
    'carol-morris_f380b@example.com',
    STR_TO_DATE('1989-08-08', '%Y-%m-%d'),
    2
  ),
  (
    'Dale Reed',
    'male',
    9600,
    23,
    'dale-reed_465f5@example.com',
    STR_TO_DATE('1985-08-08', '%Y-%m-%d'),
    1
  ),
  (
    'Mary Coleman',
    'female',
    9600,
    28,
    'mary-coleman_ea8d5@example.com',
    STR_TO_DATE('1986-08-08', '%Y-%m-%d'),
    4
  ),
  (
    'Vivian Jenkins',
    'female',
    7500,
    23,
    'vivian-jenkins_6ca7b@example.com',
    STR_TO_DATE('1981-08-08', '%Y-%m-%d'),
    5
  );


INSERT INTO AUTHORS (username, PASSWORD, email, bio) 
VALUES
  (
    'hikerAA',
    'dsa22das8@',
    'tias2@example.com',
    'Stay foolish'
  ),
  (
    'cata213',
    'd34258f*da',
    'ct@example.com',
    'Keep calm'
  ),
  (
    'qpe',
    'sd21f##121',
    'qqppe@example.com',
    'Just do it'
  ),
  (
    'timtim',
    'jh54348',
    'ttmail@example.com',
    'Nothing is impossible'
  ),
  (
    'whatistech',
    '5984*151',
    'qqra21@example.com',
    'Be water, my friend'
  ),
  (
    'i_love_bbq',
    '432978417ASD',
    'bbq@example.com',
    'I believe I can fly'
  );


INSERT INTO blogs (title, author_id) 
VALUES
  (
    'How to write a blog post that catches attention',
    1
  ),
  ('Introduction to JavaScript', 2),
  (
    'How to use the this keyword of javascript',
    3
  ),
  (
    'What you do not know about javascript',
    4
  ),
  ('Notes on MySQL primary key', 5),
  ('Best JS snippets ever', 6),
  ('My Trip to China', 1),
  ('New Zealand Experience', 1),
  ('Fly to Kyoto', 2),
  (
    'My first day as programmer in Japan',
    5
  );
