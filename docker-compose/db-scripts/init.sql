CREATE DATABASE hotels_database;

USE hotels_database;

-- CLEAN UP
DROP TABLE IF EXISTS forecasted_hotel_occupancy;

-- DDL
CREATE TABLE IF NOT EXISTS forecasted_hotel_occupancy (
    id BIGINT NOT NULL AUTO_INCREMENT,
    hotel_code VARCHAR(5) NOT NULL,
    forecast_date DATE NOT NULL,
    forecast_occupancy_percentage DECIMAL(5,2) NOT NULL,
    last_updated TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);


-- DML
INSERT INTO forecasted_hotel_occupancy (hotel_code, forecast_date, forecast_occupancy_percentage, last_updated) 
VALUES ('NY001', '2024-12-22', 70.00, NOW());