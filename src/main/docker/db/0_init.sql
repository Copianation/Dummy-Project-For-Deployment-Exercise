CREATE DATABASE demo;
\connect demo;
CREATE TABLE staff(
    staff_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address_id SMALLINT,
    email VARCHAR(50),
    active BOOLEAN,
    username VARCHAR(50),
    password VARCHAR(50),
    last_update TIMESTAMP
);


CREATE USER springuser WITH PASSWORD '12345678';
GRANT SELECT, UPDATE ON TABLE staff TO springuser;
