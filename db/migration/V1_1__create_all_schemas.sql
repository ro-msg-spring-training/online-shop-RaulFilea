CREATE TABLE IF NOT EXISTS `supplier` (

    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20)

);


CREATE TABLE IF NOT EXISTS `product_category` (

    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL,
    `description` VARCHAR(150) NOT NULL

);

CREATE TABLE IF NOT EXISTS `customer` (

    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fname` VARCHAR(20) NOT NULL,
    `lname` VARCHAR(20) NOT NULL,
    `username` VARCHAR(20) NOT NULL,
    `password` VARCHAR(32) NOT NULL,
    `email` VARCHAR(30) NOT NULL

);

CREATE TABLE IF NOT EXISTS `location` (

    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL,
    `country` VARCHAR(20) NOT NULL,
    `city` VARCHAR(30) NOT NULL,
    `county` VARCHAR(30) NOT NULL,
    `street` VARCHAR(50) NOT NULL

);

CREATE TABLE IF NOT EXISTS `product` (

    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL,
    `description` VARCHAR(150) NOT NULL,
    `price` FLOAT NOT NULL,
    `weight` FLOAT NOT NULL,
    `category` INTEGER NOT NULL,
    `supplier` INTEGER NOT NULL,
    `imageurl` VARCHAR(150) NOT NULL

);

CREATE TABLE IF NOT EXISTS `stock` (

    `product` INTEGER NOT NULL,
    `location` INT NOT NULL,
    `quantity` INTEGER NOT NULL,
    CONSTRAINT PK_stock PRIMARY KEY (product, location)

);

CREATE TABLE IF NOT EXISTS `orders` (

    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `shipped_from` INTEGER NOT NULL,
    `customer` INTEGER NOT NULL,
    `created_at` DATETIME2 NOT NULL,
    `country` VARCHAR(20) NOT NULL,
    `city` VARCHAR(30) NOT NULL,
    `county` VARCHAR(30) NOT NULL,
    `street` VARCHAR(50) NOT NULL

);

CREATE TABLE IF NOT EXISTS `order_detail` (

    `thisorder` INTEGER NOT NULL,
    `product` INTEGER NOT NULL,
    `quantity` INTEGER NOT NULL,
    CONSTRAINT PK_order_detail PRIMARY KEY (thisorder, product)

);