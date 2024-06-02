CREATE DATABASE `tas_laptop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE tas_laptop.product_type (
	id BIGINT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	CONSTRAINT product_type_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tas_laptop.product (
	id BIGINT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	`type` BIGINT NOT NULL,
	price DOUBLE NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY (id),
	CONSTRAINT product_product_type_FK FOREIGN KEY (`type`) REFERENCES tas_laptop.product_type(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE tas_laptop.`transaction` (
	id BIGINT auto_increment NOT NULL,
	customer_email varchar(500) NOT NULL,
	tax_rate DOUBLE NULL,
	tax_amount DOUBLE NULL,
	delivery_fee DOUBLE NULL,
	`time` DATETIME NOT NULL,
	CONSTRAINT transaction_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
CREATE INDEX transaction_time_IDX USING BTREE ON tas_laptop.`transaction` (`time`);

CREATE TABLE tas_laptop.transaction_item (
	transaction_id BIGINT NOT NULL,
	item_id INT NOT NULL,
	price DOUBLE NOT NULL,
	profit_margin DOUBLE NULL,
	profit_amount DOUBLE NULL,
	product_id BIGINT NOT NULL,
	product_name VARCHAR(100) NULL,
	product_type_id BIGINT NULL,
	product_type_name VARCHAR(100) NULL,
	CONSTRAINT transaction_item_pk PRIMARY KEY (transaction_id,item_id),
	CONSTRAINT transaction_item_transaction_FK FOREIGN KEY (transaction_id) REFERENCES tas_laptop.`transaction`(id),
	CONSTRAINT transaction_item_product_FK FOREIGN KEY (product_id) REFERENCES tas_laptop.product(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
