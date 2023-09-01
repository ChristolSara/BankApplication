DROP TABLE IF EXISTS Loans;
CREATE TABLE Loans (
 loan_number INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
 customer_id INTEGER NOT NULL,
 start_dt Date,
 loan_type VARCHAR(255) NOT NULL,
 total_loan INTEGER NOT NULL,
 amount_paid INTEGER NOT NULL,
 outstanding_amount INTEGER NOT NULL,
 create_dt DATE



);

INSERT INTO `Loans` (`customer_id`, `start_dt`, `loan_type`,`total_loan`,`amount_paid`,`outstanding_amount`,`create_dt`)
VALUES
(2, '2002-10-22','type',3200,200,1000,'2004-11-02'),
(1, '1991-02-23','visa',3500,1300,1000,'1992-06-15'),
(1,'2003-05-13','master',1200,200,1000,'2005-02-23'),
(4,'2010-04-29','gold',2000,350,10000,'2012-06-10');


