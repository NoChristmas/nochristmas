use nochristmas;
CREATE TABLE users (
	usr_no INT auto_increment PRIMARY KEY,
    usr_id VARCHAR(255) NOT NULL,
    usr_pwd VARCHAR(255) NOT NULL,
    usr_time timestamp DEFAULT current_timestamp
);

CREATE TABLE boards (
	bd_no INT auto_increment PRIMARY KEY,
    bd_name VARCHAR(255) NOT NULL,
    bd_time timestamp DEFAULT current_timestamp
);