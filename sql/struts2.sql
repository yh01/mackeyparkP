create database if not exists struts2;
use struts2;

drop table if exists test;
create table test(

id int, password varchar(255),credit int

);

insert into test(id,password)values(1,"test");
insert into test(id,password,credit)values(2,"test",2);

drop table if exists test2;
create table test2(

cardid int

);

insert into test2(cardid)values(1);