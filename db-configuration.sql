create database db_rent_a_car;
create user 'admin' identified by 'admin123';
grant all on db_rent_a_car.* to 'admin';
create table users;
create table orders;
create table cars;