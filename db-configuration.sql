create database db_rent_a_car;
create user 'admin' identified by 'admin123';
grant all on db_rent_a_car.* to 'admin';
USE db_rent_a_car;
ALTER TABLE user_data ENGINE = InnoDB;
ALTER TABLE user_data ADD CONSTRAINT user_email_uq UNIQUE (email);
