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
    dept_id int unsigned not null unique,
    dept_name varchar(30) not null,
    location varchar(30),
    manager_id int unsigned,
    primary key (id)
) engine=innodb default charset=utf8;

alter table departments add unique (dept_id);

create table employees (
    id int unsigned not null auto_increment,
    emp_id int unsigned not null unique,
    name varchar(30) not null,
    gender enum('female', 'male'),
    age int(3) unsigned,
    email varchar(50),
    salary int(8) unsigned,
    date_of_birth date,
    dept_id int unsigned not null,
    primary key (id),
    foreign key (dept_id) references departments(dept_id)
) engine=innodb default charset=utf8;

alter table employees add unique (emp_id);

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
insert into departments (dept_id, dept_name, location, manager_id) values
(1001, 'IT', 'Seattle', 15004),
(1002, 'Accounting', 'Seattle', 15005),
(1003, 'PR', 'New York', 15001),
(1004, 'HR', 'New York', 15006),
(1005, 'Marketing', 'New York', 15002),
(1006, 'Support', 'Seattle', 15003);

insert into employees (emp_id, name, gender, salary, age, email, date_of_birth, dept_id) values
(15001, 'Adam Smith', 'male', 8000, 20, 'adam-smith_37ec3@example.com', str_to_date('1985-08-08', '%Y-%m-%d'), 1006),
(15002, 'Robert Allen', 'male', 7000, 22, 'robert-allen_200ef@example.com', str_to_date('1982-08-08', '%Y-%m-%d'), 1003),
(15003, 'Carol Morris', 'female', 10000, 26, 'carol-morris_f380b@example.com', str_to_date('1989-08-08', '%Y-%m-%d'), 1002),
(15004, 'Dale Reed', 'male', 9600, 23, 'dale-reed_465f5@example.com', str_to_date('1985-08-08', '%Y-%m-%d'), 1001),
(15005, 'Mary Coleman', 'female', 9600, 28, 'mary-coleman_ea8d5@example.com', str_to_date('1986-08-08', '%Y-%m-%d'), 1004),
(15006, 'Vivian Jenkins', 'female', 7500, 23, 'vivian-jenkins_6ca7b@example.com', str_to_date('1981-08-08', '%Y-%m-%d'), 1005);

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
