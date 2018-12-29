-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.3-alpha-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hr_system
--

CREATE DATABASE IF NOT EXISTS hr_system;
USE hr_system;

--
-- Definition of table `allowance_mast`
--

DROP TABLE IF EXISTS `allowance_mast`;
CREATE TABLE `allowance_mast` (
  `allow_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `all_name` varchar(45) NOT NULL,
  `all_per` int(10) unsigned NOT NULL,
  `fixed_amt` int(10) unsigned NOT NULL,
  PRIMARY KEY (`allow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allowance_mast`
--

/*!40000 ALTER TABLE `allowance_mast` DISABLE KEYS */;
INSERT INTO `allowance_mast` (`allow_id`,`all_name`,`all_per`,`fixed_amt`) VALUES 
 (1,'Mehfffl',10,100),
 (2,'Mehfffl',10,100),
 (3,'Mehfffl',10,100000),
 (4,' Mehfdsfgdfgffl',10,100000);
/*!40000 ALTER TABLE `allowance_mast` ENABLE KEYS */;


--
-- Definition of table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `att_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` int(10) unsigned NOT NULL,
  `att_date` date DEFAULT NULL,
  PRIMARY KEY (`att_id`) USING BTREE,
  KEY `FK_attendance_emp_id` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` (`att_id`,`emp_id`,`att_date`) VALUES 
 (1,4,'2018-08-17'),
 (2,9,'2018-01-01'),
 (3,9,'2018-01-02'),
 (4,9,'2018-01-03'),
 (5,9,'2018-01-04'),
 (6,9,'2018-01-05'),
 (7,9,'2018-01-06'),
 (8,9,'2018-01-07'),
 (9,9,'2018-01-08'),
 (10,9,'2018-01-10'),
 (11,9,'2018-01-11'),
 (12,9,'2018-01-12'),
 (13,10,'2018-08-13'),
 (14,10,'2018-08-14'),
 (15,10,'2018-08-15'),
 (16,11,'2018-08-20'),
 (18,12,'2018-08-20'),
 (19,13,'2018-08-20'),
 (20,14,'2018-08-20'),
 (21,0,'2018-08-21'),
 (23,1,'2018-08-21'),
 (24,1,'2018-08-22'),
 (25,929,'2018-08-22'),
 (26,935,'2018-08-22'),
 (27,936,'2018-08-22'),
 (28,10,'2018-08-22');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;


--
-- Definition of table `base_sal_mast`
--

DROP TABLE IF EXISTS `base_sal_mast`;
CREATE TABLE `base_sal_mast` (
  `base_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_id` int(10) unsigned NOT NULL,
  `pos_id` int(10) unsigned NOT NULL,
  `base_salary` int(10) unsigned NOT NULL,
  `leave_days` int(10) unsigned NOT NULL,
  PRIMARY KEY (`base_id`),
  KEY `FK_base_sal_mast_pos` (`pos_id`),
  KEY `FK_base_sal_mast_dep` (`dept_id`),
  CONSTRAINT `FK_base_sal_mast_dep` FOREIGN KEY (`dept_id`) REFERENCES `dept_mast` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_base_sal_mast_pos` FOREIGN KEY (`pos_id`) REFERENCES `pos_mast` (`pos_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `base_sal_mast`
--

/*!40000 ALTER TABLE `base_sal_mast` DISABLE KEYS */;
INSERT INTO `base_sal_mast` (`base_id`,`dept_id`,`pos_id`,`base_salary`,`leave_days`) VALUES 
 (1,1,1,123123,22),
 (2,1,2,1234,22),
 (3,1,3,234,22),
 (4,1,4,234423423,22),
 (5,1,5,423423,22),
 (6,1,6,42345,22),
 (7,2,6,6443,22),
 (8,3,6,32145,22),
 (9,4,6,542565,22),
 (10,5,6,21346,22),
 (11,6,6,7543,22);
/*!40000 ALTER TABLE `base_sal_mast` ENABLE KEYS */;


--
-- Definition of table `dept_mast`
--

DROP TABLE IF EXISTS `dept_mast`;
CREATE TABLE `dept_mast` (
  `dept_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(45) NOT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dept_mast`
--

/*!40000 ALTER TABLE `dept_mast` DISABLE KEYS */;
INSERT INTO `dept_mast` (`dept_id`,`dept_name`) VALUES 
 (1,'Development'),
 (2,'HR'),
 (3,'Analytics'),
 (4,'DevOps'),
 (5,'Marketing'),
 (6,'Sales');
/*!40000 ALTER TABLE `dept_mast` ENABLE KEYS */;


--
-- Definition of table `des_all_mast`
--

DROP TABLE IF EXISTS `des_all_mast`;
CREATE TABLE `des_all_mast` (
  `des_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept_id` int(10) unsigned NOT NULL,
  `pos_id` int(10) unsigned NOT NULL,
  `allowances` varchar(45) NOT NULL,
  PRIMARY KEY (`des_id`) USING BTREE,
  KEY `FK_des_allow_mast_pos` (`pos_id`),
  KEY `FK_des_allow_mast_dept` (`dept_id`),
  CONSTRAINT `FK_des_allow_mast_dept` FOREIGN KEY (`dept_id`) REFERENCES `dept_mast` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_des_allow_mast_pos` FOREIGN KEY (`pos_id`) REFERENCES `pos_mast` (`pos_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `des_all_mast`
--

/*!40000 ALTER TABLE `des_all_mast` DISABLE KEYS */;
INSERT INTO `des_all_mast` (`des_id`,`dept_id`,`pos_id`,`allowances`) VALUES 
 (1,1,1,'1,2,3');
/*!40000 ALTER TABLE `des_all_mast` ENABLE KEYS */;


--
-- Definition of table `emp_pos_dept_history`
--

DROP TABLE IF EXISTS `emp_pos_dept_history`;
CREATE TABLE `emp_pos_dept_history` (
  `pos_dep_hist_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` int(10) unsigned NOT NULL,
  `pos_id` int(10) unsigned NOT NULL,
  `dept_id` int(10) unsigned NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `status` enum('Active','Inactive') NOT NULL,
  PRIMARY KEY (`pos_dep_hist_id`),
  KEY `FK_emp_pos_dept_history_dep` (`dept_id`),
  KEY `FK_emp_pos_dept_history_pos` (`pos_id`),
  CONSTRAINT `FK_emp_pos_dept_history_dep` FOREIGN KEY (`dept_id`) REFERENCES `dept_mast` (`dept_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_emp_pos_dept_history_pos` FOREIGN KEY (`pos_id`) REFERENCES `pos_mast` (`pos_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emp_pos_dept_history`
--

/*!40000 ALTER TABLE `emp_pos_dept_history` DISABLE KEYS */;
INSERT INTO `emp_pos_dept_history` (`pos_dep_hist_id`,`emp_id`,`pos_id`,`dept_id`,`start_date`,`end_date`,`status`) VALUES 
 (1,1,1,1,'2012-10-10 05:30:00',NULL,'Active'),
 (2,1,1,1,'2012-10-10 05:30:00',NULL,'Active'),
 (3,932,3,3,NULL,NULL,'Active'),
 (4,933,1,3,NULL,NULL,'Active'),
 (5,934,1,1,NULL,NULL,'Active'),
 (6,935,1,1,NULL,NULL,'Active'),
 (7,936,1,6,NULL,NULL,'Active'),
 (8,937,2,2,NULL,NULL,'Active'),
 (9,938,2,2,NULL,NULL,'Active'),
 (10,930,1,1,NULL,NULL,'Active'),
 (11,931,3,3,'2018-08-22 00:00:00',NULL,'Active'),
 (13,0,3,4,'2018-08-22 00:00:00',NULL,'Active'),
 (14,938,1,1,'2018-08-22 00:00:00',NULL,'Active'),
 (15,939,1,1,'2018-08-22 00:00:00',NULL,'Active'),
 (16,940,1,2,'2018-08-22 00:00:00',NULL,'Active'),
 (17,941,3,3,'2018-08-22 00:00:00',NULL,'Active'),
 (18,942,3,2,'2018-08-22 00:00:00',NULL,'Active'),
 (19,944,3,3,'2018-08-22 00:00:00',NULL,'Active');
/*!40000 ALTER TABLE `emp_pos_dept_history` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `emp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `full_name` varchar(64) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `pan_no` varchar(255) DEFAULT NULL,
  `aadhar_no` varchar(255) DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT 'tempPassword',
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `test` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=945 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`emp_id`,`full_name`,`qualification`,`address`,`mobile`,`pan_no`,`aadhar_no`,`marital_status`,`joining_date`,`photo`,`email_id`,`password`,`role`) VALUES 
 (1,'Mehul','la','BlaBlaBla','7461432792','12345678910','45678913456','Eligible Bachelor','2017-08-17 00:00:00','asdfghjkl','a@b','123','ADMIN'),
 (9,' Its_me','my_quaal','null','93','asdf1354p','123456789','yes','2018-08-17 00:00:00',' no','ab@c',' youcantpass','USER'),
 (10,'change1','change2','change3','null','asdf1354p','123456789','yes','2017-08-17 00:00:00','no','something@nothing','changeLast','ADMIN'),
 (11,' Its_me','my_quaal','null','null','asdf1354p','123456789','yes','2018-08-17 00:00:00',' no','ab@cd',' youcantpass','USER'),
 (12,' Its_me','my_quaal','null','null','asdf1354p','123456789','yes','2018-08-17 00:00:00',' no','a@bc',' youcantpass','USER'),
 (13,' Its_me','my_quaal','null','null','asdf1354p','123456789','yes','2018-08-17 00:00:00',' no','a@bcd',' youcantpass','USER'),
 (14,'Mehul','szdkhfzsdfzk','BlaBla','7461432792','12348910','45678913456',' Bachelor','2017-08-17 00:00:00','asdfghjkl','asdfg@yoItsMe','blablabla','USER'),
 (15,'Mehul','la','BlaBlaBla','7461432792','12345678910','45678913456','Eligible Bachelor','2017-08-17 00:00:00','asdfghjkl','abc@d','blablabla','USER'),
 (910,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:49:18',' null','a@bcde','tempPassword','USER'),
 (911,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:49:37',' null','a@c','tempPassword','USER'),
 (912,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:49:58',' null','a@d','tempPassword','USER'),
 (913,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:50:01',' null','a@e','tempPassword','USER'),
 (914,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:50:22',' null','a@f','tempPassword','USER'),
 (915,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:51:40',' null','a@g','tempPassword','USER'),
 (916,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:53:47',' null','a@h','tempPassword','USER'),
 (917,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 04:59:33',' null','a@i','tempPassword','USER'),
 (918,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 05:05:28',' null','a@j','tempPassword','USER'),
 (919,' ffsdfsdsdffsd','ggyfjhjggjkg','fsdfsdfsdfsdfsd','','','','','2018-08-22 05:06:55',' null','a@k','tempPassword','USER'),
 (929,' Mehul Kaushik','Bahut Pro Hai! Really!','Will not tell, is not safe','9211786420','ERTNG7265Q','7513984561548','UNMARRIED','2018-08-22 00:00:00',' null','mehul@kaushik.com','tempPassword','USER'),
 (930,' fdfdfd','fasf','fsdasfdasf','fsadf','sfdafsadf','fasdfsadfsdf','MARRIED','2018-08-22 10:33:08','null','l@q','tempPassword',' USER'),
 (931,' fdfdfd','fasf','fsdasfdasf','fsadf','sfdafsadf','fasdfsadfsdf','MARRIED','2018-08-22 10:40:15','null','l@j','tempPassword',' USER'),
 (932,' fdfdfd','fasf','fsdasfdasf','fsadf','sfdafsadf','fasdfsadfsdf','MARRIED','2018-08-22 10:41:51','null','l@u','tempPassword',' USER'),
 (933,' fdfdfd','fasf','fsdasfdasf','fsadf','sfdafsadf','fasdfsadfsdf','MARRIED','2018-08-22 10:42:50','null','l@r','tempPassword',' USER'),
 (934,' asfsadf','fsadgasg','sfdasdf','asfsadf','asgsag','asdgsadgsa','UNMARRIED','2018-08-22 10:43:53','null','l@y','tempPassword',' USER'),
 (935,' asfsadf','fsadgasg','sfdasdf','asfsadf','asgsag','asdgsadgsa','UNMARRIED','2018-08-22 10:46:31','null','l@z','tempPassword',' USER'),
 (936,' sf','fsfsdsfd','sdffsdfsd','','','','','2018-08-22 10:53:33','null','fgs@dfvfd','tempPassword',' '),
 (938,' sfgfg','fsfsdsfd','sdffsdfsd','2344235253','gf','sdgd','MARRIED','2018-08-22 10:56:10','null','fgs@dfvfdff','tempPassword',' USER'),
 (939,' fsd','gh','qwer','12','12','21','UNMARRIED','2018-08-22 10:58:12','null','uyf@po','tempPassword',' USER'),
 (940,' sfsd','fsadfas','afdsfds','2134','25636','2653','UNMARRIED','2018-08-22 10:59:30','null','afsdfds@ewf','tempPassword',' USER'),
 (941,' gf','ui','ui','ui','ui','ui','UNMARRIED','2018-08-22 11:00:56','null','fh@uiui','tempPassword',' USER'),
 (942,' sfafsdfd','fsdfsdfd','ffdfd','fdfd','fdfd','fdfdfdfd','MARRIED','2018-08-22 11:04:43','null','fsfsadfsdfsd@fdfdfd','tempPassword',' USER'),
 (943,' dssdsd','gbfgfb','fdgdgd','gfgdd','gdgfgfg','gffdsd','MARRIED','2018-08-22 11:05:38','null','q@rt','tempPassword',' USER'),
 (944,' fgs','rrrr','rrr','rr','rr','rr','UNMARRIED','2018-08-22 11:06:49','null','gg@rrr','tempPassword',' USER');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `leaves`
--

DROP TABLE IF EXISTS `leaves`;
CREATE TABLE `leaves` (
  `leave_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` int(10) unsigned DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `approved_date` datetime DEFAULT NULL,
  `status` varchar(255) NOT NULL DEFAULT 'Applied',
  PRIMARY KEY (`leave_id`),
  KEY `FK_leave_empid` (`emp_id`),
  CONSTRAINT `FK_leave_empid` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leaves`
--

/*!40000 ALTER TABLE `leaves` DISABLE KEYS */;
INSERT INTO `leaves` (`leave_id`,`emp_id`,`start_date`,`end_date`,`approved_date`,`status`) VALUES 
 (2,1,'2012-11-10 05:30:00','2012-11-14 05:30:00','2012-11-10 05:30:00','Approved'),
 (4,1,'2012-10-10 00:00:00','2012-10-15 00:00:00',NULL,'Approved'),
 (5,10,'2012-11-10 05:30:00','2012-11-14 05:30:00','2012-11-10 05:30:00','Approved'),
 (6,10,'2012-11-10 05:30:00','2012-11-14 05:30:00','2012-11-10 05:30:00','null'),
 (7,11,'2012-11-10 05:30:00','2012-11-14 05:30:00','2012-11-10 05:30:00','null'),
 (8,11,'2012-11-10 05:30:00','2012-11-14 05:30:00','2012-12-10 05:30:00','Applied'),
 (9,1,'2013-11-10 00:00:00','2013-12-14 00:00:00','2013-12-14 00:00:00','Applied'),
 (10,1,'2013-11-10 00:00:00','2013-12-14 00:00:00','2013-12-14 00:00:00','Applied'),
 (11,1,'2013-11-10 00:00:00','2013-12-14 00:00:00','1899-12-31 00:00:00','Applied'),
 (12,1,'2013-11-10 00:00:00','2013-12-14 00:00:00','1899-12-31 00:00:00','Applied'),
 (13,1,'2018-08-22 00:00:00','2018-08-28 00:00:00','1899-12-31 00:00:00','Approved'),
 (14,1,'2018-08-22 00:00:00','2018-08-30 00:00:00','1899-12-31 00:00:00','Approved'),
 (15,1,'2018-08-28 00:00:00','2018-08-31 00:00:00','1899-12-31 00:00:00','Applied'),
 (16,1,'2018-08-22 00:00:00','2018-08-29 00:00:00','1899-12-31 00:00:00','Applied'),
 (17,1,'2018-08-29 00:00:00','2018-08-30 00:00:00','1899-12-31 00:00:00','Applied'),
 (18,1,'2018-08-27 00:00:00','2018-08-30 00:00:00','1899-12-31 00:00:00','Applied'),
 (19,1,'2018-08-28 00:00:00','2018-08-30 00:00:00','1899-12-31 00:00:00','Applied'),
 (20,1,'2018-08-22 00:00:00','2018-08-23 00:00:00','1899-12-31 00:00:00','Applied'),
 (21,1,'2018-08-23 00:00:00','2018-08-29 00:00:00','1899-12-31 00:00:00','Applied'),
 (22,1,'2018-08-28 00:00:00','2018-08-30 00:00:00','1899-12-31 00:00:00','Applied'),
 (23,929,'2018-08-23 00:00:00','2018-08-31 00:00:00','1899-12-31 00:00:00','Approved');
/*!40000 ALTER TABLE `leaves` ENABLE KEYS */;


--
-- Definition of table `pos_mast`
--

DROP TABLE IF EXISTS `pos_mast`;
CREATE TABLE `pos_mast` (
  `pos_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pos_name` varchar(45) NOT NULL,
  PRIMARY KEY (`pos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pos_mast`
--

/*!40000 ALTER TABLE `pos_mast` DISABLE KEYS */;
INSERT INTO `pos_mast` (`pos_id`,`pos_name`) VALUES 
 (1,'Developer'),
 (2,'Senior Devloper'),
 (3,'Junior Manager'),
 (4,'Manager'),
 (5,'Senior Manager'),
 (6,' Intern');
/*!40000 ALTER TABLE `pos_mast` ENABLE KEYS */;


--
-- Definition of table `salary_mast`
--

DROP TABLE IF EXISTS `salary_mast`;
CREATE TABLE `salary_mast` (
  `salary_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_id` int(10) unsigned NOT NULL,
  `base_id` int(10) unsigned NOT NULL DEFAULT '0',
  `deductions` int(10) unsigned NOT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `FK_salary_master_emp` (`emp_id`),
  KEY `FK_salary_master_base` (`base_id`),
  CONSTRAINT `FK_salary_master_base` FOREIGN KEY (`base_id`) REFERENCES `base_sal_mast` (`base_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_salary_master_emp` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salary_mast`
--

/*!40000 ALTER TABLE `salary_mast` DISABLE KEYS */;
INSERT INTO `salary_mast` (`salary_id`,`emp_id`,`base_id`,`deductions`) VALUES 
 (2,1,1,10000),
 (3,9,2,20000),
 (4,10,3,30000),
 (5,11,4,40000);
/*!40000 ALTER TABLE `salary_mast` ENABLE KEYS */;


--
-- Definition of table `salarywise_all_mast`
--

DROP TABLE IF EXISTS `salarywise_all_mast`;
CREATE TABLE `salarywise_all_mast` (
  `all_mast_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `salary_id` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  `allowance_id` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  `allowance_amt` int(10) unsigned zerofill NOT NULL DEFAULT '0000000000',
  PRIMARY KEY (`all_mast_id`),
  KEY `FK_salarywise_all_mast_sal` (`salary_id`) USING BTREE,
  CONSTRAINT `FK_salarywise_all_mast_sal` FOREIGN KEY (`salary_id`) REFERENCES `salary_mast` (`salary_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salarywise_all_mast`
--

/*!40000 ALTER TABLE `salarywise_all_mast` DISABLE KEYS */;
INSERT INTO `salarywise_all_mast` (`all_mast_id`,`salary_id`,`allowance_id`,`allowance_amt`) VALUES 
 (2,0000000002,0000000004,0000000002);
/*!40000 ALTER TABLE `salarywise_all_mast` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
