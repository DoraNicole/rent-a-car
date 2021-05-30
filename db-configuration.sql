create database db_rent_a_car;
create user 'admin' identified by 'admin123';
grant all on db_rent_a_car.* to 'admin';
USE db_rent_a_car;
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    orders LONGTEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    car_id INT NOT NULL,
    pickup_date DATE NOT NULL,
    return_date DATE NOT NULL,
    price INT NOT NULL,
    confirmed boolean NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;
CREATE TABLE IF NOT EXISTS cars (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    nr_chairs INT NOT NULL ,
    automatic boolean NOT NULL ,
    nr_big_luggage INT NOT NULL,
    nr_small_luggage INT NOT NULL,
    location VARCHAR(255) NOT NULL,
    price_per_day INT NOT NULL,
    available boolean NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;
ALTER TABLE user_data ENGINE = InnoDB;
ALTER TABLE user_data ADD CONSTRAINT user_email_uq UNIQUE (email);
INSERT INTO users(firstName, lastName, email, user_password, phone, orders) VALUES ('dora', 'tilica', 'tilica.dora@gmail.com', 'dora123', '0711111111', '');
INSERT INTO cars(brand, model, nr_chairs, automatic, nr_big_luggage, nr_small_luggage, location, price_per_day, available)
VALUES ('Volkswagen', 'Polo', 5, false, 0, 1, 'Bucuresti Otopeni Aeroport', 102, true);
INSERT INTO cars(brand, model, nr_chairs, automatic, nr_big_luggage, nr_small_luggage, location, price_per_day, available)
VALUES ('Opel', 'Astra', 5, true, 1, 1, 'Bucuresti Otopeni Aeroport', 154, true);
INSERT INTO orders(user_id, car_id, pickup_date, return_date, price, confirmed) VALUES (1, 1, '2021-05-20', '2021-05-21', 102, true);
INSERT INTO users(firstName, lastName, email, user_password, phone, orders) VALUES ('nico', 'tilica', 't.dora@gmail.com', 'dora123', '0711111111', '');
