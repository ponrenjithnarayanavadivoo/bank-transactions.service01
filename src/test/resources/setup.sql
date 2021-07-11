CREATE DATABASE ABC_BANK;
drop table if exists ABC_BANK_TRANSACTION_DETAILS;
CREATE TABLE ABC_BANK_TRANSACTION_DETAILS(
		transaction_id VARCHAR(30) NOT NULL ,
		account_number VARCHAR(20) NOT NULL,
        transaction_timestamp TIMESTAMP,
        PRIMARY KEY (transaction_id));