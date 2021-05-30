create database db_rent_a_car;
create user 'admin' identified by 'admin123';
grant all on db_rent_a_car.* to 'admin';
USE db_rent_a_car;
ALTER TABLE user_data ENGINE = InnoDB;
ALTER TABLE user_data ADD CONSTRAINT user_email_uq UNIQUE (email);
INSERT INTO users(firstName, lastName, email, user_password, phone, orders) VALUES ('dora', 'tilica', 'tilica.dora@gmail.com', 'dora123', '0711111111', '');
INSERT INTO cars(brand, model, nr_chairs, automatic, nr_big_luggage, nr_small_luggage, location, price_per_day, available)
VALUES ('Volkswagen', 'Polo', 5, false, 0, 1, 'Bucuresti Otopeni Aeroport', 102, true);
INSERT INTO cars(brand, model, nr_chairs, automatic, nr_big_luggage, nr_small_luggage, location, price_per_day, available)
VALUES ('Opel', 'Astra', 5, true, 1, 1, 'Bucuresti Otopeni Aeroport', 154, true);
INSERT INTO orders(user_id, car_id, pickup_date, return_date, price, confirmed) VALUES (1, 1, '2021-05-20', '2021-05-21', 102, true);
INSERT INTO users(firstName, lastName, email, user_password, phone, orders) VALUES ('nico', 'tilica', 't.dora@gmail.com', 'dora123', '0711111111', '');
