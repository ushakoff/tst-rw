DROP SCHEMA IF EXISTS `rw_db` ;
CREATE SCHEMA `rw_db` DEFAULT CHARACTER SET utf8;
USE `rw_db` ;

CREATE TABLE `rw_db`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `login` (`login`))
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE `role_name` (`role_name`))
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`user_to_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL DEFAULT 1,
  FOREIGN KEY (`user_id`)
    REFERENCES `rw_db`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (`role_id`)
    REFERENCES `rw_db`.`role` (`role_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`profile` (
  `user_id` INT NOT NULL,
  `first_name` VARCHAR(255) DEFAULT NULL,
  `last_name` VARCHAR(255) DEFAULT NULL,
  `email` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  FOREIGN KEY (`user_id`)
    REFERENCES `rw_db`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE `name` (`name`))
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`discount` (
  `discount_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `category_id` INT NOT NULL,
  `percent` INT DEFAULT 0,
  PRIMARY KEY (`discount_id`),
  FOREIGN KEY (`category_id`)
    REFERENCES `rw_db`.`category` (`category_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`detail` (
  `discount_id` INT NOT NULL,
  `info` TEXT DEFAULT NULL,
  `site` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`discount_id`),
  FOREIGN KEY (`discount_id`)
    REFERENCES `rw_db`.`discount` (`discount_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE `rw_db`.`codes` (
  `code_id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) NOT NULL,
  `user_id` INT NOT NULL,
  `discount_id` INT NOT NULL,
  PRIMARY KEY (`code_id`),
  FOREIGN KEY (`user_id`)
    REFERENCES `rw_db`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (`discount_id`)
    REFERENCES `rw_db`.`discount` (`discount_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `rw_db`.`role` (`role_id`, `role_name`) VALUES (1, 'User');
INSERT INTO `rw_db`.`role` (`role_id`, `role_name`) VALUES (2, 'Moderator');
INSERT INTO `rw_db`.`role` (`role_id`, `role_name`) VALUES (3, 'Administrator');

INSERT INTO `rw_db`.`user` (`user_id`, `login`, `password`) VALUES (1, 'ivanov', '111');
INSERT INTO `rw_db`.`user` (`user_id`, `login`, `password`) VALUES (2, 'petrov', '222');
INSERT INTO `rw_db`.`user` (`user_id`, `login`, `password`) VALUES (3, 'sidorov', '333');
INSERT INTO `rw_db`.`user` (`user_id`, `login`, `password`) VALUES (4, 'admin', 'admin');
INSERT INTO `rw_db`.`user` (`user_id`, `login`, `password`) VALUES (5, 'moder', 'moder');
INSERT INTO `rw_db`.`user` (`user_id`, `login`, `password`) VALUES (6, 'user', 'user');

INSERT INTO `rw_db`.`user_to_role` (`user_id`, `role_id`) VALUES (1, 3);
INSERT INTO `rw_db`.`user_to_role` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `rw_db`.`user_to_role` (`user_id`, `role_id`) VALUES (3, 1);
INSERT INTO `rw_db`.`user_to_role` (`user_id`, `role_id`) VALUES (4, 3);
INSERT INTO `rw_db`.`user_to_role` (`user_id`, `role_id`) VALUES (5, 2);
INSERT INTO `rw_db`.`user_to_role` (`user_id`, `role_id`) VALUES (6, 1);

INSERT INTO `rw_db`.`profile` (`user_id`, `first_name`, `last_name`, `email`) VALUES (1, 'Ivan', 'Ivanov', 'ivanov@gmail.com');
INSERT INTO `rw_db`.`profile` (`user_id`, `first_name`, `last_name`, `email`) VALUES (2, 'Petr', 'Petrov', 'petrov@gmail.com');
INSERT INTO `rw_db`.`profile` (`user_id`, `first_name`, `last_name`, `email`) VALUES (3, 'Sidor', 'Sidorov', 'sidorov@gmail.com');
INSERT INTO `rw_db`.`profile` (`user_id`, `first_name`, `last_name`, `email`) VALUES (4, 'Aaaa', 'Aaaa', 'aaaa@aaaa.com');
INSERT INTO `rw_db`.`profile` (`user_id`, `first_name`, `last_name`, `email`) VALUES (5, 'Bbbb', 'Bbbb', 'bbbb@bbbb.com');
INSERT INTO `rw_db`.`profile` (`user_id`, `first_name`, `last_name`, `email`) VALUES (6, 'Cccc', 'Cccc', 'cccc@cccc.com');

INSERT INTO `rw_db`.`category` (`category_id`, `name`) VALUES (1, 'Sport');
INSERT INTO `rw_db`.`category` (`category_id`, `name`) VALUES (2, 'Hotels');
INSERT INTO `rw_db`.`category` (`category_id`, `name`) VALUES (3, 'Food');

INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (1, 1, '24HourFitness', '10');
INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (2, 3, 'Restaurant Gift Certificate', '15');
INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (3, 2, 'Raddison Blu Edwardian hotels', '5');
INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (4, 1, 'eBags New Collection', '5');
INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (5, 3, 'Dinner at Quince Restaurant', '20');
INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (6, 2, 'Fairmont Hotels & Resorts ', '12');
INSERT INTO `rw_db`.`discount` (`discount_id`, `category_id`, `name`, `percent`) VALUES (7, 3, 'Cookies by Design discount', '15');

INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (1, 'Sign up as a new 24 Hour Fitness member and get 10% off of your purchase.', '24hourfitness.com');
INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (2, 'Restaurant.com offers the best deal, every meal. With nearly 50,000 deals and thousands of restaurants nationwide, Restaurant.com is the ultimate resource for diners who want to eat well and save money. Gift Certificates from 5% to 15%, and allow customers to save at thousands of restaurants across the country with just a few clicks. The dining deals never expire, cost customers a fraction of the face value and come with a 100% customer satisfaction guarantee.', 'Restaurant.com');
INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (3, 'Receive 5% off your accommodation and 25% off breakfast at all Radisson Blu Edwardian hotels (including May Fair), and a complimentary welcome drink when you book with the code', 'RaddisonHotel.com');
INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (4, 'eBags is the largest online retailer of handbags, luggage and accessories. They are known for their complete line of premium and popular brands (over 500 brands and 40,000 products), including Samsonite, JanSport, Kenneth Cole Reaction and Derek Alexander. From backpacks and carry-ons to computer cases and handbags, eBags combines the best selection of products with unrivaled service and extremely competitive prices.', 'eBags.com');
INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (5, 'Highly rated by Zagat, certified green, and given Michelin notoriety, Quince serves contemporary American Cuisine with global and seasonal inspirations. Showcasing the simplicity of wood-planked walls and the warmth of a rustic fireplace, dining room, located inside the historic Homestead Hotel, serves elegant fare in a comfortable and relaxed setting. Quince Restaurant offers an a la carte menu, a five-course chef tasting menu, as well as a grand chef tasting menu. To redeem this offer, and receive your 20% discount with the purchase of two entrees at Quince, show or print out a copy of this code and present it to your server when ordering', 'QuinceRestaurant.com');
INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (6, 'Use your code when booking your stay at Thistle Hotels and receive up to 12% off our best available rate. Your rate includes a nights accommodation and breakfast, and a room upgrade available at most Thistle Hotels across the U.K. Upgrade excludes Thistle Heathrow, Thistle Manchester, Bloomsbury Park in London and Thistle Poole.', 'Fairmont.com');
INSERT INTO `rw_db`.`detail` (`discount_id`, `info`, `site`) VALUES (7, 'Cookies by Design offers freshly baked, hand decorated cookie bouquets and treats that can be personalized for any occasion. We are delighted to now offer a Gluten Free Gift Range. Don’t forget our NFL, MLB and NCAA gifts that are perfect for that sports fan in your life. To redeem this offer, enter the code during the checkout process.', 'CookiesbyDesign.com');

INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (1, '974C5DA5-11', 1, 1);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (2, '2156B03F-4C', 1, 1);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (3, 'C70C72BA-CF', 1, 2);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (4, '8C81D867-91', 2, 3);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (5, 'CA394120-7A', 3, 1);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (6, '40424A24-72', 3, 4);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (7, '2195CF3A-57', 3, 5);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (8, '276C4F12-E1', 3, 2);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (9, 'BF2FDB4C-92', 6, 6);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (10, 'FC046BDB-1F', 4, 5);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (11, '970453F3-26', 5, 3);
INSERT INTO `rw_db`.`codes` (`code_id`, `code`, `user_id`, `discount_id`) VALUES (12, '8AE2EB04-0C', 5, 7);