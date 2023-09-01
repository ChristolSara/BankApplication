DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS ACCOUNT;

CREATE TABLE CUSTOMER (
 customer_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(255) NOT NULL,
 email VARCHAR(255) NOT NULL,
 mobile_number VARCHAR(255) NOT NULL,
 create_dt DATE

);

CREATE TABLE ACCOUNT (

 account_number INTEGER NOT NULL PRIMARY KEY,
 account_type VARCHAR(255) NOT NULL,
 branch_address VARCHAR(255) NOT NULL,
 create_dt DATE NOT NULL,
 customer_id INTEGER NOT NULL,
 FOREIGN KEY(customer_id) REFERENCES CUSTOMER(customer_id)

);
INSERT INTO `CUSTOMER` (`name`, `email`, `mobile_number`,`create_dt`)
VALUES
('Doe', 'john@yahoo.fr','54354136413','2004-11-02'),
('Smith', 'jane@hotmail.com','0556556596','1992-06-15'),
('Dupont', 'sebastien@orange.fr','545242354','2005-02-23'),
('Martin', 'emilie@gmail.com','35463546','2012-06-10');

INSERT INTO `ACCOUNT` (`account_number`, `account_type`, `branch_address`,`create_dt`,`customer_id`)
VALUES
(564489, 'courant','54354136413','2004-11-02',2),
(584665, 'epargne','0556556596','1992-06-15',1),
(326674, 'livret A','545242354','2005-02-23',1),
(115287, 'courant','35463546','2012-06-10',3);
