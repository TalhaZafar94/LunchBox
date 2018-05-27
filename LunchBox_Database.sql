/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.6.20 : Database - lunchbox
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lunchbox` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lunchbox`;

/*Table structure for table `addresses` */

DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `address_postalcode` varchar(10) DEFAULT NULL,
  `address_lastupdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `addresses` */

insert  into `addresses`(`address_id`,`address`,`city`,`address_postalcode`,`address_lastupdated`) values (1,'Defence view ,karachi','karachi',NULL,'2018-03-02 23:38:31'),(2,'Malir ,g-45','karachi',NULL,'2018-03-02 23:41:47'),(3,'mehmoodabad,karachi','karachi',NULL,'2018-03-03 00:02:59'),(4,'nazimabad,karachi','karachi',NULL,'2018-03-03 00:04:20'),(5,'malir','karachi',NULL,'2018-03-03 01:00:25'),(6,'E.162','karachi',NULL,'2018-03-06 23:56:29'),(7,'','karachi',NULL,'2018-03-07 21:02:52'),(8,'','karachi',NULL,'2018-03-07 21:29:30'),(9,'','karachi',NULL,'2018-03-07 21:40:32'),(10,'','karachi',NULL,'2018-03-07 22:02:50'),(11,'fdfds','karachi',NULL,'2018-03-07 23:54:56'),(12,'sfdsfg','karachi',NULL,'2018-03-08 00:02:32'),(13,'sfdsfg','karachi',NULL,'2018-03-08 00:02:50'),(14,'dgfdgf','karachi',NULL,'2018-03-08 00:08:32'),(15,'sadfsf','karachi',NULL,'2018-03-08 00:10:26'),(16,'safdsf','karachi',NULL,'2018-03-08 00:18:49');

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(15) DEFAULT NULL,
  `admin_email` varchar(25) DEFAULT NULL ,
  `admin_nic` varchar(15) DEFAULT NULL,
  `admin_accesstype` int(11) DEFAULT NULL,
  `admin_password` varchar(300) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `admin_imagepath` varchar(50) DEFAULT NULL,
  `admin_phonenumber` varchar(15) DEFAULT NULL,
  `admin_createdat` datetime DEFAULT NULL,
  `admin_lastupdated` timestamp NULL DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `NewIndex1` (`address_id`),
  CONSTRAINT `FK_admins` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FKd22ndptupnu1wj0fawg36qfmh` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `admins` */

insert  into `admins`(`admin_id`,`admin_name`,`admin_email`,`admin_nic`,`admin_accesstype`,`admin_password`,`address_id`,`admin_imagepath`,`admin_phonenumber`,`admin_createdat`,`admin_lastupdated`,`id`) values (2,'talha','talha@gmail.com','988754213',NULL,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',NULL,NULL,NULL,NULL,NULL,NULL),(3,'junaid','junaid@gmail.com','988754213',NULL,'3b24b06b033c6e436989ca4a113b0d92befaa2dca28f3dc611dba19e6b1d62cd5fdccace3074529c52384a8053f6a549236680ea432a766d54368d0',NULL,NULL,NULL,NULL,NULL,NULL),(4,'khizar','khizar@gmail.com','988754213',NULL,'ff585f1a2c9913a78375346cb3c82396cf930b59dd459468e0784d2ecc2983ad31b4bcb438e1355c593f36e12f09695139de191e14d534523de6b275190',NULL,NULL,NULL,NULL,NULL,NULL),(5,'ali','ali@gmail.com','1564564',1,'22e7e9d85b7fe604f7b9f3aa592ea9ec9ce98682e8192fa83785f1784c768d1d1ac3b8afcae88666f66aec24739ac133e9d4adc7506f1a5f1f6078cb27c674',1,NULL,'05185155',NULL,NULL,NULL),(6,'Hamza','hamza@gmail.com','789754542',2,'22e7e9d85b7fe604f7b9f3aa592ea9ec9ce98682e8192fa83785f1784c768d1d1ac3b8afcae88666f66aec24739ac133e9d4adc7506f1a5f1f6078cb27c674',2,NULL,'03032226',NULL,NULL,NULL),(7,'admin','admin123@gmail.com','4658435',2,'3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb3abb9e3a6df2ac2c20fe23436311d678564dc8d305930575f60e2d3d048184d79',6,NULL,'564654165',NULL,NULL,NULL),(12,'noman','noman@gmail.com','574984321',2,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',11,NULL,'3216512',NULL,NULL,NULL),(13,'rana','rana@gmail.com','53465123',2,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',12,NULL,'124651',NULL,NULL,NULL),(15,'fawad','fawad@gmail.com','2655464',2,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',14,NULL,'54832',NULL,NULL,NULL),(16,'akram','akram@gmail.com','54685132',2,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',15,NULL,'16541',NULL,NULL,NULL),(17,'jhon','jhon@gmail.com','264564',2,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',16,NULL,'8545123',NULL,NULL,NULL);

/*Table structure for table `blocked_users` */

DROP TABLE IF EXISTS `blocked_users`;

CREATE TABLE `blocked_users` (
  `blocked_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `foodmaker_id` int(11) DEFAULT NULL,
  `rider_id` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `blocked_date` datetime DEFAULT NULL,
  PRIMARY KEY (`blocked_id`),
  UNIQUE KEY `NewIndex1` (`customer_id`,`foodmaker_id`,`rider_id`),
  KEY `FK_rider_id` (`rider_id`),
  KEY `FK_admin_id` (`admin_id`),
  KEY `FK_foodmaker_id` (`foodmaker_id`),
  CONSTRAINT `FK_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`),
  CONSTRAINT `FK_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FK_foodmaker_id` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`),
  CONSTRAINT `FK_rider_id` FOREIGN KEY (`rider_id`) REFERENCES `riders` (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `blocked_users` */

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(50) DEFAULT NULL,
  `customer_nic` varchar(14) DEFAULT NULL,
  `customer_email` varchar(25) DEFAULT NULL,
  `customer_accesstype` int(11) DEFAULT NULL,
  `customer_password` varchar(300) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `customer_imagepath` varchar(50) DEFAULT NULL,
  `customer_phonenumber` varchar(15) DEFAULT NULL,
  `customer_createdat` datetime DEFAULT NULL,
  `customer_lastupdated` timestamp NULL DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `addressid` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `NewIndex1` (`address_id`,`location_id`),
  UNIQUE KEY `UK_1shqea1tuuv03k2syp6b8ejti` (`addressid`),
  KEY `FK_location_id` (`location_id`),
  CONSTRAINT `FK_address_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `customers` */

insert  into `customers`(`customer_id`,`customer_name`,`customer_nic`,`customer_email`,`customer_accesstype`,`customer_password`,`address_id`,`customer_imagepath`,`customer_phonenumber`,`customer_createdat`,`customer_lastupdated`,`location_id`,`addressid`) values (1,'talha ','4220136759607','talhazafar2011@gmail.com',2,'123',NULL,'121212','03362086168',NULL,NULL,NULL,NULL),(2,'khizar','4220136759607','khizar@gmail.com',2,'123',NULL,NULL,'154984891',NULL,NULL,NULL,NULL),(3,'talha','4220133145678','talhazafar521@gmail.com',2,'123',NULL,NULL,'03362086168',NULL,NULL,NULL,NULL),(4,'jk','423016549875','junaidkhan046@gmail.com',2,'486',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'aamir','123456789','aamirkhan@gmail.com',2,'888',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'junaid','988754213','junaidkhan046@gmail.com',2,'28155',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'farhan','988754213','farhan@gmail.com',2,'d404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'afridi','988754213','adridi@gmail.com',2,'3c999afec25354d551dae2159bb26e38d53f2173b8d3dc3eee4c47e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'khan','988754213','khan@gmail.com',2,'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'yasir','988754213','yasir@gmail.com',2,'3c999afec25354d551dae2159bb26e38d53f2173b8d3dc3eee4c47e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `dishes` */

DROP TABLE IF EXISTS `dishes`;

CREATE TABLE `dishes` (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(15) DEFAULT NULL,
  `dish_sellingprice` double DEFAULT NULL,
  `dish_availabletime` time DEFAULT NULL,
  `dish_imagepath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `dishes` */

insert  into `dishes`(`dish_id`,`dish_name`,`dish_sellingprice`,`dish_availabletime`,`dish_imagepath`) values (7,'briyani',NULL,NULL,NULL),(8,'khorma',NULL,NULL,NULL),(9,'khorma',500,NULL,NULL),(10,'khorma',500,NULL,'asdasdasdasdsadasd'),(11,'khorma',500,'05:23:22','asdasdasdasdsadasd'),(12,'tikka',500,'05:23:22','asdasdasdasdsadasd'),(13,NULL,NULL,NULL,NULL),(14,NULL,NULL,NULL,NULL),(15,NULL,NULL,NULL,NULL),(16,'khorma',500,NULL,'asdasdasdasdsadasd');

/*Table structure for table `dishes_categories` */

DROP TABLE IF EXISTS `dishes_categories`;

CREATE TABLE `dishes_categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(15) DEFAULT NULL,
  `dish_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK_dishe_id` (`dish_id`),
  CONSTRAINT `FK_dishe_id` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dishes_categories` */

/*Table structure for table `dishes_controller` */

DROP TABLE IF EXISTS `dishes_controller`;

CREATE TABLE `dishes_controller` (
  `dish_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_availabletime` time DEFAULT NULL,
  `dish_imagepath` varchar(255) DEFAULT NULL,
  `dish_name` varchar(255) DEFAULT NULL,
  `dish_sellingprice` double DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dishes_controller` */

/*Table structure for table `foodmaker_dishes` */

DROP TABLE IF EXISTS `foodmaker_dishes`;

CREATE TABLE `foodmaker_dishes` (
  `foodmaker_dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_id` int(11) NOT NULL,
  `foodmaker_id` int(11) NOT NULL,
  PRIMARY KEY (`foodmaker_dishes_id`),
  KEY `dish_id` (`dish_id`),
  CONSTRAINT `dish_id` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`),
  CONSTRAINT `foodmaker_id` FOREIGN KEY (`foodmaker_dishes_id`) REFERENCES `foodmakers` (`foodmaker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `foodmaker_dishes` */

/*Table structure for table `foodmakers` */

DROP TABLE IF EXISTS `foodmakers`;

CREATE TABLE `foodmakers` (
  `foodmaker_id` int(11) NOT NULL AUTO_INCREMENT,
  `foodmaker_name` varchar(15) DEFAULT NULL,
  `foodmaker_email` varchar(25) DEFAULT NULL,
  `foodmaker_nic` varchar(15) DEFAULT NULL,
  `foodmaker_password` varchar(300) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `foodmaker_accesstype` int(11) DEFAULT NULL,
  `foodmaker_imagepath` varchar(50) DEFAULT NULL,
  `foodmaker_active` int(11) DEFAULT NULL,
  `foodmaker_phonenumber` varchar(15) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `foodmaker_createdat` datetime DEFAULT NULL,
  `foodmaker_lastupdated` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`foodmaker_id`),
  UNIQUE KEY `FK_addressid` (`address_id`),
  KEY `FK_adminid` (`admin_id`),
  CONSTRAINT `FK9pm9s3nqn4k9spqq06jgvetme` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_addressid` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_adminid` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `foodmakers` */

insert  into `foodmakers`(`foodmaker_id`,`foodmaker_name`,`foodmaker_email`,`foodmaker_nic`,`foodmaker_password`,`address_id`,`foodmaker_accesstype`,`foodmaker_imagepath`,`foodmaker_active`,`foodmaker_phonenumber`,`admin_id`,`foodmaker_createdat`,`foodmaker_lastupdated`) values (1,'foodmaker1','foodmaker1@gmail.com','1235464','22e7e9d85b7fe604f7b9f3aa592ea9ec9ce98682e8192fa83785f1784c768d1d1ac3b8afcae88666f66aec24739ac133e9d4adc7506f1a5f1f6078cb27c674',3,NULL,NULL,2,'1245787452',NULL,NULL,NULL),(2,'foodmaker2','foodmaker2@gmail.com','12654898','22e7e9d85b7fe604f7b9f3aa592ea9ec9ce98682e8192fa83785f1784c768d1d1ac3b8afcae88666f66aec24739ac133e9d4adc7506f1a5f1f6078cb27c674',4,NULL,NULL,1,'124574874141',NULL,NULL,NULL),(3,'foodmaker3','foodmaker3@gmail.com','5498432132','22e7e9d85b7fe604f7b9f3aa592ea9ec9ce98682e8192fa83785f1784c768d1d1ac3b8afcae88666f66aec24739ac133e9d4adc7506f1a5f1f6078cb27c674',5,NULL,NULL,1,'54132165',NULL,NULL,NULL);

/*Table structure for table `locations` */

DROP TABLE IF EXISTS `locations`;

CREATE TABLE `locations` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `locations` */

/*Table structure for table `order_dishes` */

DROP TABLE IF EXISTS `order_dishes`;

CREATE TABLE `order_dishes` (
  `orderdishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `dish_id` int(11) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  PRIMARY KEY (`orderdishes_id`),
  KEY `FK_dishes_id` (`dish_id`),
  KEY `FK_orders_id` (`order_id`),
  CONSTRAINT `FK_dishes_id` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`),
  CONSTRAINT `FK_orders_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `order_dishes` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `reservation_id` int(11) DEFAULT NULL,
  `shipment_address` varchar(50) DEFAULT NULL,
  `order_date` datetime DEFAULT NULL,
  `order_deliver_date` datetime DEFAULT NULL,
  `order_totalamount` float DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_customers_id` (`customer_id`),
  KEY `FK_reservations_id` (`reservation_id`),
  CONSTRAINT `FK_customers_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FK_reservations_id` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`reservation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `orders` */

/*Table structure for table `payments` */

DROP TABLE IF EXISTS `payments`;

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `payment_cleared` int(11) DEFAULT NULL,
  `payment_date` datetime DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `FK_order_id` (`order_id`),
  CONSTRAINT `FK_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `payments` */

/*Table structure for table `ratings` */

DROP TABLE IF EXISTS `ratings`;

CREATE TABLE `ratings` (
  `rating_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `dish_id` int(11) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `FK_customerid` (`customer_id`),
  KEY `FK_dishid` (`dish_id`),
  CONSTRAINT `FK_customerid` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FK_dishid` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ratings` */

/*Table structure for table `reservations` */

DROP TABLE IF EXISTS `reservations`;

CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `foodmaker_id` int(11) DEFAULT NULL,
  `rider_id` int(11) DEFAULT NULL,
  `reservation_date` date DEFAULT NULL,
  `reservation_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `FK_foodmakerid` (`foodmaker_id`),
  KEY `FK_riders_id` (`rider_id`),
  CONSTRAINT `FK_foodmakerid` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`),
  CONSTRAINT `FK_riders_id` FOREIGN KEY (`rider_id`) REFERENCES `riders` (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reservations` */

/*Table structure for table `riders` */

DROP TABLE IF EXISTS `riders`;

CREATE TABLE `riders` (
  `rider_id` int(11) NOT NULL AUTO_INCREMENT,
  `rider_name` varchar(15) DEFAULT NULL,
  `rider_nic` varchar(15) DEFAULT NULL,
  `rider_password` varchar(300) DEFAULT NULL,
  `rider_accesstype` int(11) DEFAULT NULL,
  `rider_phonenumber` varchar(15) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `rider_imagepath` varchar(50) DEFAULT NULL,
  `rider_active` int(11) DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `rider_createdat` datetime DEFAULT NULL,
  `rider_lastupdated` timestamp NULL DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `rider_email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`rider_id`),
  UNIQUE KEY `FK_loca_id` (`location_id`),
  UNIQUE KEY `FK_addresss_id` (`address_id`),
  UNIQUE KEY `FK_vehicles_id` (`vehicle_id`),
  KEY `FK_adminsid` (`admin_id`),
  CONSTRAINT `FK_addresss_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_adminsid` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`),
  CONSTRAINT `FK_loca_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`),
  CONSTRAINT `FK_vehicles_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `riders` */

/*Table structure for table `tokens` */

DROP TABLE IF EXISTS `tokens`;

CREATE TABLE `tokens` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token_id` varchar(100) DEFAULT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_token` (`token_id`),
  KEY `admin_id` (`admin_id`),
  CONSTRAINT `admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tokens` */

/*Table structure for table `updatedishes` */

DROP TABLE IF EXISTS `updatedishes`;

CREATE TABLE `updatedishes` (
  `updatedishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `foodmaker_id` int(11) DEFAULT NULL,
  `dish_id` int(11) DEFAULT NULL,
  `dish_amount` double DEFAULT NULL,
  PRIMARY KEY (`updatedishes_id`),
  KEY `FK_fmaker_id` (`foodmaker_id`),
  KEY `FK_did` (`dish_id`),
  CONSTRAINT `FK_did` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`),
  CONSTRAINT `FK_fmaker_id` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `updatedishes` */

/*Table structure for table `vehicles` */

DROP TABLE IF EXISTS `vehicles`;

CREATE TABLE `vehicles` (
  `vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_number` varchar(15) DEFAULT NULL,
  `vehicle_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `vehicles` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
