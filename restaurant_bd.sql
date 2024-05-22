CREATE DATABASE restaurant_db_final;

USE restaurant_db;

CREATE TABLE restaurant (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description TEXT,
                            address VARCHAR(255) NOT NULL,
                            schedule VARCHAR(255),
                            type VARCHAR(45),
                            created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE table_food (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            capacity INT NOT NULL,
                            number INT NOT NULL,
                            is_available BOOLEAN NOT NULL DEFAULT TRUE,
                            created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            CONSTRAINT `table_to_restaurant` FOREIGN KEY (id_restaurant) REFERENCES Restaurant(id) ON DELETE  RESTRICT ON UPDATE CASCADE
);

CREATE TABLE booking (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         number_of_people INT NOT NULL,  -- Consider if needed based on table_food capacity
                         date DATE NOT NULL,
                         food INT NOT NULL,
                         status BOOLEAN NOT NULL DEFAULT  TRUE,
                         status_payment BOOLEAN NOT NULL DEFAULT  FALSE,
                         id_restaurant INT NOT NULL,
                         id_table_food INT NOT NULL,
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                         updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         CONSTRAINT `booking_to_table` FOREIGN KEY (id_table_food) REFERENCES table_food(id) ON DELETE  RESTRICT ON UPDATE CASCADE
    -- FOREIGN KEY (id_customer) REFERENCES Customer(id)
);

