create database if not exists struts2;
use struts2;

drop table if exists test;
create table test(

id int, password varchar(255)

);

insert into test(id,password)values(1,"test");