drop database IF EXISTS PROJ1;
create database IF NOT EXISTS PROJ1;
use PROJ1;

create table account(
	accountnr int NOT NULL AUTO_INCREMENT,
	username varchar(24) NOT NULL,
    password varchar(32) NOT NULL,
    PRIMARY KEY(accountnr)
);