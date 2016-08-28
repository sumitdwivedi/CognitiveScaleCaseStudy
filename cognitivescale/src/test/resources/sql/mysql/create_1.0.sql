--------------------------------------------------------------------------------------------------------
-- File name       : create.sql
-- Purpose         : SQL script to perform database changes required by the bank poc application.
-- Usage Guidelines: Execute this script to run bank poc application.
-- Database Schema
-- Version         : 1.0.
--------------------------------------------------------------------------------------------------------


CREATE DATABASE  IF NOT EXISTS `cognitivescale`;
USE `cognitivescale`;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE customer(
 `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
customer_id VARCHAR( 200 ) ,
first_name VARCHAR( 200 ) ,
last_name VARCHAR( 200 ) ,
age int ,
address VARCHAR( 200 ) ,
country VARCHAR( 15 ) ,
email VARCHAR( 200 ) ,
sex VARCHAR( 15 ) ,
contact_number int,
created_userid VARCHAR( 200 ),
modified_userid VARCHAR( 200 ),
created_timestamp TIMESTAMP ,
modified_timestamp TIMESTAMP

);

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE account(
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
customer_id VARCHAR( 200 ) ,
account_num VARCHAR( 200 ) ,
balance FLOAT,
acc_type VARCHAR( 200 ) ,
account_open_date DATE,
created_userid VARCHAR( 200 ),
modified_userid VARCHAR( 200 ),
created_timestamp TIMESTAMP ,
modified_timestamp TIMESTAMP
);
--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE login (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
user_name varchar(200) ,
user_password varchar(200) ,
user_type varchar(200) ,
question varchar(200) ,
ans varchar(200),
created_userid VARCHAR( 200 ),
modified_userid VARCHAR( 200 ),
created_timestamp TIMESTAMP ,
modified_timestamp TIMESTAMP 
);

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE transactions (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
transaction_id varchar(200) ,
transaction_type varchar(200) ,
transaction_method varchar(200) ,
date timestamp ,
cheque_num varchar(200) ,
account_num varchar(200) ,
amount varchar(200) ,
current_balance varchar(200) ,
remarks timestamp ,
customer_id varchar(200),
created_userid VARCHAR( 200 ),
modified_userid VARCHAR( 200 ),
created_timestamp TIMESTAMP ,
modified_timestamp TIMESTAMP
);

--
-- Table structure for table `beneficiary`
--

DROP TABLE IF EXISTS `beneficiary`;
CREATE TABLE beneficiary (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
account_num varchar(200) ,
ifcs_code varchar(200) ,
nick_name varchar(200) ,
customer_id varchar(200) ,
account_name varchar(200),
created_userid VARCHAR( 200 ),
modified_userid VARCHAR( 200 ),
created_timestamp TIMESTAMP ,
modified_timestamp TIMESTAMP 
);




