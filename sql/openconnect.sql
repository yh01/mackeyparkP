create database if not exists openconnect;

use openconnect;

drop table if exists user;

create table user (

user_id int primary key not null auto_increment,

password varchar(255),

user_name varchar(50) not null,

name_kana varchar(50),

mail_address varchar(100) unique key ,

credit_number varchar(4),

token varchar(255),

unique_id varchar(50),

oauth_name varchar(50),

user_registration_date datetime,

user_updated_date datetime

);

insert into user(password,user_name,name_kana,mail_address,credit_number,user_registration_date)
value("user","user01","ユーザー","user01@gmail.com","1234",now());
insert into user(password,user_name,name_kana,mail_address,user_registration_date)
value("user2","user02","ユーザー2","user02@gmail.com",now());


drop table if exists admin;
create table admin (

id int primary key not null auto_increment,

admin_id varchar(25) unique key not null,

admin_password varchar(255) not null,

admin_registration_date datetime not null,

admin_updated_date datetime

);

insert into admin(admin_id,admin_password,admin_registration_date)values("admin01","admin",now());