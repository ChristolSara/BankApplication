DROP TABLE IF EXISTS CARDS;
CREATE TABLE CARDS (
 card_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
 customer_id INTEGER NOT NULL,
 card_number VARCHAR(255) NOT NULL,
 card_type VARCHAR(255) NOT NULL,
 total_limit INTEGER NOT NULL,
 amount_used INTEGER NOT NULL,
 available_amount INTEGER NOT NULL,
 create_dt DATE



);

INSERT INTO `CARDS` (`customer_id`, `card_number`, `card_type`,`total_limit`,`amount_used`,`available_amount`,`create_dt`)
VALUES
(2, '54354136413','visa',3200,200,1000,'2004-11-02'),
(1, '0556556596','visa',3500,1300,1000,'1992-06-15'),
(1,'545242354','master',1200,200,1000,'2005-02-23'),
(4,'35463546','gold',2000,350,10000,'2012-06-10');


