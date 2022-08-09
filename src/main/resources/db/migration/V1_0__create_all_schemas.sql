CREATE TABLE IF NOT EXISTS `supplier` (

    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20)

);

CREATE TABLE IF NOT EXISTS `product_category` (

    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20),
    `description` VARCHAR(150)

);

CREATE TABLE IF NOT EXISTS `customer` (

    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `fname` VARCHAR(20),
    `lname` VARCHAR(20),
    `username` VARCHAR(20),
    `password` VARCHAR(32),
    `email` VARCHAR(30)

);

CREATE TABLE IF NOT EXISTS `location` (

    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(220),
    `address_country` VARCHAR(220),
    `address_city` VARCHAR(230),
    `address_county` VARCHAR(230),
    `address_street` VARCHAR(250)

);

CREATE TABLE IF NOT EXISTS `product` (

    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20),
    `description` VARCHAR(150),
    `price` FLOAT,
    `weight` FLOAT,
    `category_id` INTEGER,
    `supplier_id` INTEGER,
    `imageurl` VARCHAR(150)

);

CREATE TABLE IF NOT EXISTS `stock` (

    `product_id` INTEGER,
    `location_id` INT,
    `quantity` INTEGER,
    CONSTRAINT PK_stock PRIMARY KEY (product_id, location_id)

);

CREATE TABLE IF NOT EXISTS `orders` (

    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `shipped_from_id` INTEGER,
    `customer_id` INTEGER,
    `created_at` DATETIME2,
    `country` VARCHAR(20),
    `city` VARCHAR(30),
    `county` VARCHAR(30),
    `street` VARCHAR(50)

);

CREATE TABLE IF NOT EXISTS `order_detail` (

    `thisorder_id` INTEGER,
    `product_id` INTEGER,
    `quantity` INTEGER,
    CONSTRAINT PK_order_detail PRIMARY KEY (thisorder_id, product_id)

);