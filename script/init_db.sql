# This SQL script is used for database initialization for MySQL RDBMS
# MAKE SURE YOU DON'T HAVE A DATABASE NAMED `mybatisdemo` with useful data stored in it

## initialize database
drop database if exists mybatisdemo;
create database mybatisdemo
charset 'utf8'
collate 'utf8_general_ci';

## initialize tables
use mybatisdemo;
drop table if exists departments;

create table departments (
    id int unsigned not null auto_increment,
    dept_name varchar(30) not null,
    primary key (id)
) engine=innodb default charset=utf8;

create table employees (
    id int unsigned not null auto_increment,
    name varchar(30) not null,
    gender enum('female', 'male'),
    salary int(8),
    age int(3),
    city varchar(30),
    dept_id int unsigned,
    primary key (id),
    foreign key (dept_id) references departments(id)
) engine=innodb default charset=utf8;

create table authors (
    id int unsigned not null auto_increment,
    username varchar(30) not null,
    password varchar(50),
    email varchar(30),
    bio varchar(255),
    primary key (id)
) engine=innodb default charset=utf8;

create table blogs (
    id int unsigned not null auto_increment,
    title varchar(50) not null,
    author_id int unsigned not null,
    primary key (id),
    foreign key (author_id) references authors(id)
) engine=innodb default charset=utf8;

## inert test data
insert into departments (dept_name) values
('IT'), ('Accounting'), ('PR'), ('HR'), ('Marketing'), ('Support');

insert into employees (name, gender, salary, age, city, dept_id) values
('Adam', 'male', 8000, 20, 'New York', 6),
('Abraham', 'male', 9500, 25, 'New York', 6),
('Bob', 'male', 7000, 22, 'London', 3),
('Carol', 'female', 10000, 26, 'Tokyo', 2),
('Dale', 'male', 9600, 23, 'New York', 1),
('Tom', 'male', 12500, 28, 'Beijing', 1),
('Mary', 'female', 9600, 28, 'Edmonton', 4),
('Vivian', 'female', 7500, 23, 'Ontario', 5);

insert into authors (username, password, email, bio) values
('hikerAA', 'dsa22das8@', 'tias2@example.com', 'Stay foolish'),
('cata213', 'd34258f*da', 'ct@example.com', 'Keep calm'),
('qpe', 'sd21f##121', 'qqppe@example.com', 'Just do it'),
('timtim', 'jh54348', 'ttmail@example.com', 'Nothing is impossible'),
('whatistech', '5984*151', 'qqra21@example.com', 'Be water, my friend'),
('i_love_bbq', '432978417ASD', 'bbq@example.com', 'I believe I can fly');

insert into blogs (title, author_id) values
('How to write a blog post that catches attention', 1),
('Introduction to JavaScript', 2),
('How to use the this keyword of javascript', 3),
('What you do not know about javascript', 4),
('Notes on MySQL primary key', 5),
('Best JS snippets ever', 6),
('My Trip to China', 1),
('New Zealand Experience', 1),
('Fly to Kyoto', 2),
('My first day as programmer in Japan', 5);
