drop database if exists openconnect;
create database openconnect;
use openconnect;

create table user(
id int not null auto_increment,
user_id varchar(25) unique,
user_name varchar(255),
password varchar(255),
user_kana varchar(255),
gender enum('male','female'),
birthday date,
email varchar(100),
credit_number varchar(4),
credit_token varchar(255),
oauth_id varchar(50),
oauth_name varchar(50),
registration_date datetime,
updated_date datetime,
postal_code varchar(8),
address varchar(100),
cell_number varchar(15),
primary key(id)
);

insert into user(id,user_name,password,user_kana,gender,birthday,email,registration_date,postal_code,address,cell_number)
value
(1,"まっきー1","mackeypark1","マッキー1",'male',"2000-01-01 01:00:00","mackeypark1@docomo.ne.jp","2016-03-14 01:00:00","1111111","東京都文京区湯島1-1-1","08011111111"),
(2,"まっきー2","mackeypark1","マッキー2",'female',"2000-01-02 01:00:00","mackeypark2@docomo.ne.jp","2016-03-15 01:00:00","1111112","東京都文京区湯島1-1-2","08011111112"),
(3,"まっきー3","mackeypark1","マッキー3",'male',"2000-01-03 01:00:00","mackeypark3@docomo.ne.jp","2016-03-16 01:00:00","1111113","東京都文京区湯島1-1-3","08011111113"),
(4,"まっきー4","mackeypark1","マッキー4",'female',"2000-01-04 01:00:00","mackeypark4@docomo.ne.jp","2016-03-17 01:00:00","1111114","東京都文京区湯島1-1-4","08011111114");

create table if not exists site(
id int(10) NOT NULL AUTO_INCREMENT,
name varchar(50),
url varchar(255),
PRIMARY KEY (id)
);

create table if not exists admin(
id int(11) not null auto_increment,
admin_id varchar(25) unique,
password varchar(255) not null,
primary key(id)
);

insert into admin values(1,"1","admin01");


insert into site(name,url)
values('YouJustJewelry','http://www.internousdev.com:8080/YouJustJewelry/'),
('solare','http://www.internousdev.com:8080/solare/'),
('UESTO','http://www.internousdev.com:8080/UESTO/'),
('WorldTravel','http://www.internousdev.com:8080/WorldTravel/'),
('gpscoffee','http://www.internousdev.com:8080/gpscoffee/'),
('la-poupee','http://www.internousdev.com:8080/la-poupee/');