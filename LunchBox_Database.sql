/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.6.20 : Database - lunchbox
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = '' */;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS */`lunchbox` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `lunchbox`;

/*Table structure for table `addresses` */

DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `address_id`          int(11)   NOT NULL AUTO_INCREMENT,
  `address`             varchar(50)        DEFAULT NULL,
  `city`                varchar(15)        DEFAULT NULL,
  `address_postalcode`  varchar(10)        DEFAULT NULL,
  `address_lastupdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 64
  DEFAULT CHARSET = latin1;

/*Data for the table `addresses` */

insert into `addresses` (`address_id`, `address`, `city`, `address_postalcode`, `address_lastupdated`)
values (2, 'Malir ,g-45', 'karachi', NULL, '2018-03-02 23:41:47'),
  (3, 'mehmoodabad,karachi', 'karachi', NULL, '2018-03-03 00:02:59'),
  (4, 'nazimabad,karachi', 'karachi', NULL, '2018-03-03 00:04:20'),
  (5, 'malir', 'karachi', NULL, '2018-03-03 01:00:25'), (6, 'E.162', 'karachi', NULL, '2018-03-06 23:56:29'),
  (7, '', 'karachi', NULL, '2018-03-07 21:02:52'), (8, '', 'karachi', NULL, '2018-03-07 21:29:30'),
  (9, '', 'karachi', NULL, '2018-03-07 21:40:32'), (10, '', 'karachi', NULL, '2018-03-07 22:02:50'),
  (11, 'fdfds', 'karachi', NULL, '2018-03-07 23:54:56'), (12, 'sfdsfg', 'karachi', NULL, '2018-03-08 00:02:32'),
  (13, 'sfdsfg', 'karachi', NULL, '2018-03-08 00:02:50'), (14, 'dgfdgf', 'karachi', NULL, '2018-03-08 00:08:32'),
  (15, 'sadfsf', 'karachi', NULL, '2018-03-08 00:10:26'), (17, '', 'karachi', NULL, '2018-03-09 03:16:03'),
  (18, '', 'karachi', NULL, '2018-03-09 03:17:34'), (19, '', 'karachi', NULL, '2018-03-09 03:21:00'),
  (20, '', 'karachi', NULL, '2018-03-09 03:28:44'), (21, '', 'karachi', NULL, '2018-03-09 17:00:55'),
  (22, '', 'karachi', NULL, '2018-03-09 17:00:59'), (23, 'sdfsfsd', 'karachi', NULL, '2018-03-09 17:20:43'),
  (24, '', 'karachi', NULL, '2018-03-09 17:21:37'), (25, 'gdsfgdsfg', 'karachi', NULL, '2018-03-09 17:27:37'),
  (26, 'df', 'karachi', NULL, '2018-03-10 21:36:45'), (27, 'dsfdg', 'karachi', NULL, '2018-03-10 22:18:04'),
  (28, 'sdfsd', 'karachi', NULL, '2018-03-10 22:18:53'), (29, 'tretjhfgh', 'karachi', NULL, '2018-03-10 23:33:13'),
  (30, 'fgthh', 'karachi', NULL, '2018-03-18 00:20:52'), (31, 'dfgdf', 'karachi', NULL, '2018-03-18 00:46:30'),
  (34, 'asdasdad', '  Karachi', NULL, '2018-04-06 00:14:57'),
  (39, 'nazimabad,karachi', 'karachi', NULL, '2018-03-03 00:04:20'),
  (40, 'Malir ,g-45', 'karachi', NULL, '2018-03-02 23:41:47'), (41, 'malir', 'karachi', NULL, '2018-06-01 02:48:02'),
  (42, 'asdadad', 'karachi', NULL, '2018-06-01 02:51:44'), (43, 'dgfdgf', 'karachi', NULL, '2018-06-02 00:59:09'),
  (44, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:10:05'),
  (45, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:10:50'),
  (46, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:13:17'),
  (47, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:14:58'),
  (48, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:16:57'),
  (49, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:17:17'),
  (50, 'Malir ,g-45', 'karachi', NULL, '2018-06-02 01:17:23'),
  (51, 'mehmoodabad,karachi', 'karachi', NULL, '2018-06-02 01:58:14'),
  (52, 'sdfsfsd', 'karachi', NULL, '2018-06-02 01:58:23'),
  (53, 'nazimabad,karachi', 'karachi', NULL, '2018-06-07 23:43:12'),
  (54, 'nazimabad,karachi', 'karachi', NULL, '2018-06-07 23:46:50'),
  (55, 'nazimabad,karachi', 'karachi', NULL, '2018-06-07 23:47:53'),
  (56, 'nazimabad,karachi', 'karachi', NULL, '2018-06-07 23:50:57'),
  (57, 'nazimabad,karachi', 'karachi', NULL, '2018-06-07 23:59:41'),
  (58, 'nazimabad,karachi', 'karachi', NULL, '2018-06-08 00:07:14'),
  (59, 'nazimabad,karachi', 'karachi', NULL, '2018-06-24 21:30:08'),
  (60, 'Defence view phase 2', 'Karachi', NULL, '2018-06-24 22:38:16'),
  (61, 'E.162 defence view phase 2 karachi', 'Karachi', NULL, '2018-06-28 23:45:57'),
  (62, 'nazimabad', 'karachi', NULL, '2018-07-02 04:18:28'),
  (63, 'kemari karachi', 'karachi', NULL, '2018-07-02 04:30:25');

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `admin_id`          int(11)   NOT NULL AUTO_INCREMENT,
  `admin_name`        varchar(15)        DEFAULT NULL,
  `admin_email`       varchar(25)        DEFAULT NULL,
  `admin_nic`         varchar(15)        DEFAULT NULL,
  `admin_accesstype`  int(11)            DEFAULT NULL,
  `admin_password`    varchar(300)       DEFAULT NULL,
  `address_id`        int(11)            DEFAULT NULL,
  `admin_imagepath`   varchar(100)       DEFAULT NULL,
  `admin_phonenumber` varchar(15)        DEFAULT NULL,
  `admin_createdat`   datetime           DEFAULT NULL,
  `admin_lastupdated` timestamp NULL     DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `NewIndex1` (`address_id`),
  UNIQUE KEY `admin_email` (`admin_email`),
  UNIQUE KEY `admin_nic` (`admin_nic`),
  UNIQUE KEY `EMAIL_INDEX` (`admin_email`, `admin_nic`),
  CONSTRAINT `FK_admins` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FKd22ndptupnu1wj0fawg36qfmh` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 32
  DEFAULT CHARSET = latin1;

/*Data for the table `admins` */

insert into `admins` (`admin_id`, `admin_name`, `admin_email`, `admin_nic`, `admin_accesstype`, `admin_password`, `address_id`, `admin_imagepath`, `admin_phonenumber`, `admin_createdat`, `admin_lastupdated`)
values (3, 'junaid', 'junaid@gmail.com', '988754213', NULL,
  '3b24b06b033c6e436989ca4a113b0d92befaa2dca28f3dc611dba19e6b1d62cd5fdccace3074529c52384a8053f6a549236680ea432a766d54368d0',
  NULL, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\Tulips.jpg', NULL, NULL, NULL),
  (6, 'Hamza 1234', 'hamza@gmail.com', '789754542', 1, '189f4929d63d1c56d51de2a423f8aa411b47553d86376af63e1d69a4d5474feab7a27880b1d45dcd5328d7212b3904eca29e58206c721ff15ac1599139', 50, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es1.jpg', '03032226', NULL, NULL),
  (7, 'admin', 'admin123@gmail.com', '4658435', 2, '3627909a29c31381a071ec27f7c9ca97726182aed29a7ddd2e54353322cfb3abb9e3a6df2ac2c20fe23436311d678564dc8d305930575f60e2d3d048184d79', 6, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es2.jpg', '564654165', NULL, NULL),
  (12, 'noman', 'noman@gmail.com', '574984321', 2, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 11, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es2.jpg', '3216512', NULL, NULL),
  (13, 'rana', 'rana@gmail.com', '53465123', 2, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 12, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es2.jpg', '124651', NULL, NULL),
  (15, 'fawad1', 'fawad@gmail.com', '2655464', 1, '3a9d1665b176eb90b2eaa724553d49d03cd8cb5815a24c4ceb831afc4952d27b4a8228212b926d3f64b614af473a77c42ce965ee4da491939f766125c73a61', 43, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es2.jpg', '54832', NULL, NULL),
  (16, 'akram', 'akram@gmail.com', '54685132', 2, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 15, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es2.jpg', '16541', NULL, NULL),
  (19, 'ahmed', 'ahmed@gmail.com', '54654165', 2, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 27, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es2.jpg', '654651', NULL, NULL),
  (20, 'raja', 'raja@gmail.com', '42301-34530-1', 1, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 30, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\es1.jpg', '0336-2086168', NULL, NULL),
  (21, 'faizan', 'faizan@gmail.com', '42301-34880-1', 1, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 31, NULL, '0336-2086168', NULL, NULL),
  (27, 'khizar jawaid', 'khizar@gmail.com', '42301-1234567-2', NULL, '2e7d5ed3c95f1bde6fceef634cf99e13183ca7e19542f08cdff6abc31c1701be11b19df1658c69d9da4d34092a02073df4a7329fc3ccfc5276e457a18f2fe3c', NULL, NULL, '0300-2289156', NULL, NULL),
  (28, 'talha zafar', 'talhazafar521@gmail.com', '42301-3453880-1', NULL,
    'e1b7dd11996d39e26d8eead0521ad9bbd9c87443257f212c0cf98b4a92ef1e22169b36431ba8bcb5f729c561c144a9fc076e8eae8af828bfb30d0c3fa404b',
    NULL, NULL, '0336-2086168', NULL, NULL), (29, 'malik', 'malik@gmail.com', '42301-5555555-7', NULL,
  'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',
  NULL, NULL, NULL, NULL, NULL), (30, 'junaid Ahmed', 'juni@gmail.com', '45564654456', 1,
  '125d6d3b32c84d492747f79cfbf6e179d287f341384eb5d6d3197525ad6be8e6df11632935698f99a09e265073d1d6c32c274591bf1da20ad67cba921bc',
  41, NULL, '123121231', NULL, NULL), (31, 'admin 122', 'admin@gmail.com', '11231231231', 1,
  '125d6d3b32c84d492747f79cfbf6e179d287f341384eb5d6d3197525ad6be8e6df11632935698f99a09e265073d1d6c32c274591bf1da20ad67cba921bc',
  42, NULL, '131313132', NULL, NULL);

/*Table structure for table `blocked_users` */

DROP TABLE IF EXISTS `blocked_users`;

CREATE TABLE `blocked_users` (
  `blocked_id`   int(11) NOT NULL AUTO_INCREMENT,
  `customer_id`  int(11)          DEFAULT NULL,
  `foodmaker_id` int(11)          DEFAULT NULL,
  `rider_id`     int(11)          DEFAULT NULL,
  `admin_id`     int(11)          DEFAULT NULL,
  `blocked_date` datetime         DEFAULT NULL,
  PRIMARY KEY (`blocked_id`),
  UNIQUE KEY `NewIndex1` (`customer_id`, `foodmaker_id`, `rider_id`),
  KEY `FK_rider_id` (`rider_id`),
  KEY `FK_admin_id` (`admin_id`),
  KEY `FK_foodmaker_id` (`foodmaker_id`),
  CONSTRAINT `FK_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`),
  CONSTRAINT `FK_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FK_foodmaker_id` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`),
  CONSTRAINT `FK_rider_id` FOREIGN KEY (`rider_id`) REFERENCES `riders` (`rider_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `blocked_users` */

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `customer_id`          int(11)   NOT NULL AUTO_INCREMENT,
  `customer_name`        varchar(50)        DEFAULT NULL,
  `customer_nic`         varchar(14)        DEFAULT NULL,
  `customer_email`       varchar(25)        DEFAULT NULL,
  `customer_accesstype`  int(11)            DEFAULT NULL,
  `customer_password`    varchar(300)       DEFAULT NULL,
  `address_id`           int(11)            DEFAULT NULL,
  `customer_imagepath`   varchar(500)       DEFAULT NULL,
  `customer_phonenumber` varchar(15)        DEFAULT NULL,
  `customer_createdat`   datetime           DEFAULT NULL,
  `customer_lastupdated` timestamp NULL     DEFAULT NULL,
  `location_id`          int(11)            DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `NewIndex1` (`address_id`, `location_id`),
  UNIQUE KEY `customer_email` (`customer_email`),
  UNIQUE KEY `customer_nic` (`customer_nic`),
  UNIQUE KEY `EMAIL_INDEX` (`customer_email`, `customer_nic`),
  KEY `FK_location_id` (`location_id`),
  CONSTRAINT `FK_address_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`),
  CONSTRAINT `FKm07rwxbyxjv8r4fcye1ff6rmq` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 23
  DEFAULT CHARSET = latin1;

/*Data for the table `customers` */

insert into `customers` (`customer_id`, `customer_name`, `customer_nic`, `customer_email`, `customer_accesstype`, `customer_password`, `address_id`, `customer_imagepath`, `customer_phonenumber`, `customer_createdat`, `customer_lastupdated`, `location_id`)
values
  (1, 'talha ', '4220136759607', 'talhazafar2011@gmail.com', 2, '123', 2, '121212', '03362086168', NULL, NULL, NULL),
  (3, 'talha', '4220133145678', 'talhazafar521@gmail.com', 2, '123', 2, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\Penguins.jpg', '03362086168', NULL, NULL, NULL),
  (4, 'jk', '423016549875', 'junaidkhan046@gmail.com', 2, '486', 2, 'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\Penguins.jpg', NULL, NULL, NULL, NULL),
  (5, 'aamir', '123456789', 'aamirkhan@gmail.com', 2, '888', 2, NULL, NULL, NULL, NULL, NULL),
  (9, 'farhan', '98875421334', 'farhan@gmail.com', 2, 'd404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db', 2, NULL, NULL, NULL, NULL, NULL),
  (10, 'afridi', '9887542132', 'adridi@gmail.com', 2, '3c999afec25354d551dae2159bb26e38d53f2173b8d3dc3eee4c47e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', 2, NULL, NULL, NULL, NULL, NULL),
  (11, 'khan', '98875421399', 'khan@gmail.com', 2, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 2, NULL, NULL, NULL, NULL, NULL),
  (12, 'yasir', '9887542130', 'yasir@gmail.com', 2, '3c999afec25354d551dae2159bb26e38d53f2173b8d3dc3eee4c47e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2', 2, NULL, NULL, NULL, NULL, NULL),
  (13, 'sohail', '54654', 'sohail@gmail.com', 1, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 2, NULL, '4654', NULL, NULL, NULL),
  (14, 'jhon', '4251-5898745-5', 'jhon@gmail.com', NULL, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 2, NULL, '0336-2086168', NULL, NULL, NULL),
  (20, 'salman', '455987455', 'salman@gmail.com', NULL, 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 2, NULL, '0336-2086168', NULL, NULL, NULL),
  (21, 'asdasas', '561564', 'dasds@fa.com', 1,
       '8ea662b9f9481aa4f59f66c1ab747c0403693d084ec3363f1f957a78064b46cc45545f5f878314c265e996e17838f577cca19deb86e6be36c448b87366f3',
       2, NULL, '545456', NULL, NULL, NULL), (22, 'usman', '425555987455', 'usman@gmail.com', 1,
                                                  'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413',
                                                  2, NULL, '0336-2086168', NULL, NULL, NULL);

/*Table structure for table `dishes` */

DROP TABLE IF EXISTS `dishes`;

CREATE TABLE `dishes` (
  `dish_id`            int(11) NOT NULL AUTO_INCREMENT,
  `dish_name`          varchar(15)      DEFAULT NULL,
  `dish_sellingprice`  double           DEFAULT NULL,
  `dish_availabletime` time             DEFAULT NULL,
  `dish_imagepath`     varchar(50)      DEFAULT NULL,
  PRIMARY KEY (`dish_id`),
  KEY `DISH_INDEX` (`dish_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 27
  DEFAULT CHARSET = latin1;

/*Data for the table `dishes` */

insert into `dishes` (`dish_id`, `dish_name`, `dish_sellingprice`, `dish_availabletime`, `dish_imagepath`)
values (7, 'briyani', 500, '05:23:22', 'sfdsafsd'), (8, 'khorma', 500, '05:23:22', 'sfdsafsd'),
  (12, 'tikka', 500, '05:23:22', 'asdasdasdasdsadasd'), (17, 'qoorma', 600, NULL, NULL),
  (20, 'khorma', 500, '05:23:22', 'sfdsafsd'), (21, 'khorma', 500, '05:23:22', 'sfdsafsd'),
  (22, 'nihari', 200, NULL, 'safgsdg'), (23, 'salad', 200, NULL, 'safgsdg'), (24, 'zarda', 200, NULL, 'safgsdg'),
  (25, 'raita', 200, NULL, 'safgsdg'), (26, 'chikenbroast', 200, NULL, 'safgsdg');

/*Table structure for table `dishes_categories` */

DROP TABLE IF EXISTS `dishes_categories`;

CREATE TABLE `dishes_categories` (
  `category_id`   int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(15)      DEFAULT NULL,
  `dish_id`       int(11)          DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK_dishe_id` (`dish_id`),
  CONSTRAINT `FK_dishe_id` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `dishes_categories` */

/*Table structure for table `dishes_controller` */

DROP TABLE IF EXISTS `dishes_controller`;

CREATE TABLE `dishes_controller` (
  `dish_id`            int(11) NOT NULL AUTO_INCREMENT,
  `dish_availabletime` time             DEFAULT NULL,
  `dish_imagepath`     varchar(255)     DEFAULT NULL,
  `dish_name`          varchar(255)     DEFAULT NULL,
  `dish_sellingprice`  double           DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `dishes_controller` */

/*Table structure for table `foodmaker_dishes` */

DROP TABLE IF EXISTS `foodmaker_dishes`;

CREATE TABLE `foodmaker_dishes` (
  `foodmaker_dishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_id`             int(11) NOT NULL,
  `foodmaker_id`        int(11) NOT NULL,
  `description`         text,
  `image_path`          varchar(500)     DEFAULT NULL,
  `price`               double           DEFAULT NULL,
  PRIMARY KEY (`foodmaker_dishes_id`),
  KEY `dish_id` (`dish_id`),
  KEY `foodmaker_id` (`foodmaker_id`),
  CONSTRAINT `dish_id` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`),
  CONSTRAINT `foodmaker_id` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 30
  DEFAULT CHARSET = latin1;

/*Data for the table `foodmaker_dishes` */

insert into `foodmaker_dishes` (`foodmaker_dishes_id`, `dish_id`, `foodmaker_id`, `description`, `image_path`, `price`)
values (1, 7, 1, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (2, 12, 1, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL),
  (3, 20, 1, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (6, 25, 1, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL),
  (8, 26, 1, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (9, 26, 6, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL),
  (19, 12, 6, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (20, 22, 6, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL),
  (21, 22, 8, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (22, 8, 8, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL),
  (23, 20, 8, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (24, 25, 8, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL),
  (26, 7, 3, 'egfdg', 'ioeuiorwwwwwwwwwww', NULL), (27, 12, 8, 'world famous tikka',
                                                    'C:\\SpringBoot\\live\\lunchbox\\src\\main\\resources\\static\\images\\Penguins.jpg',
                                                    NULL), (28, 12, 8, 'world tikka 1', 'nothing', 25),
  (29, 22, 1, 'world best n', NULL, 500);

/*Table structure for table `foodmakers` */

DROP TABLE IF EXISTS `foodmakers`;

CREATE TABLE `foodmakers` (
  `foodmaker_id`          int(11)   NOT NULL AUTO_INCREMENT,
  `foodmaker_name`        varchar(15)        DEFAULT NULL,
  `foodmaker_email`       varchar(25)        DEFAULT NULL,
  `foodmaker_nic`         varchar(15)        DEFAULT NULL,
  `foodmaker_password`    varchar(300)       DEFAULT NULL,
  `address_id`            int(11)            DEFAULT NULL,
  `foodmaker_accesstype`  int(11)            DEFAULT NULL,
  `foodmaker_imagepath`   varchar(50)        DEFAULT NULL,
  `foodmaker_active`      int(11)            DEFAULT NULL,
  `foodmaker_phonenumber` varchar(15)        DEFAULT NULL,
  `admin_id`              int(11)            DEFAULT NULL,
  `foodmaker_createdat`   datetime           DEFAULT NULL,
  `foodmaker_lastupdated` timestamp NULL     DEFAULT NULL,
  PRIMARY KEY (`foodmaker_id`),
  UNIQUE KEY `FK_addressid` (`address_id`),
  UNIQUE KEY `foodmaker_email` (`foodmaker_email`),
  UNIQUE KEY `foodmaker_nic` (`foodmaker_nic`),
  UNIQUE KEY `EMAIL_INDEX` (`foodmaker_email`, `foodmaker_nic`),
  KEY `FK_adminid` (`admin_id`),
  CONSTRAINT `FK9pm9s3nqn4k9spqq06jgvetme` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_addressid` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_adminid` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = latin1;

/*Data for the table `foodmakers` */

insert into `foodmakers` (`foodmaker_id`, `foodmaker_name`, `foodmaker_email`, `foodmaker_nic`, `foodmaker_password`, `address_id`, `foodmaker_accesstype`, `foodmaker_imagepath`, `foodmaker_active`, `foodmaker_phonenumber`, `admin_id`, `foodmaker_createdat`, `foodmaker_lastupdated`)
values (1, 'foodmaker12', 'foodmaker1@gmail.com', '1235464',
           'c9bccf7d4c32776a44127442bf2cbf2ff36fe1e53056152b12e442d8cabcffb473dc793ece5b2802f27168f9f056e9cdf9180edb83a3fed584842339d',
           51, NULL, 'http://localhost:8080/images/es2.jpg', 1, '1245787452', NULL, NULL, NULL),
  (2, 'foodmaker21', 'foodmaker2@gmail.com', NULL, '75b1e9355a198486d4bb42068976ce9d2e74346e3e553bbdd3d44cd2b2af49fd6c2c6ab108afe6a7314a25a2a4d571c5366d4957315ea57d5a3db71113e2', 58, NULL, 'http://localhost:8080/images/es2.jpg', 1, '124574874141', NULL, NULL, NULL),
  (3, 'foodmaker3', 'foodmaker3@gmail.com', '5498432132', '22e7e9d85b7fe604f7b9f3aa592ea9ec9ce98682e8192fa83785f1784c768d1d1ac3b8afcae88666f66aec24739ac133e9d4adc7506f1a5f1f6078cb27c674', 5, NULL, 'http://localhost:8080/images/es2.jpg', 1, '54132165', NULL, NULL, NULL),
  (6, 'usama anwer', 'usama@gmail.com', '54683213', '3a9d1665b176eb90b2eaa724553d49d03cd8cb5815a24c4ceb831afc4952d27b4a8228212b926d3f64b614af473a77c42ce965ee4da491939f766125c73a61', 52, NULL, 'http://localhost:8080/images/es2.jpg', 1, '45564534', NULL, NULL, NULL),
  (8, 'aamir', 'amir@gmail.com', '5468465fg', 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 25, NULL, 'http://localhost:8080/images/es2.jpg', 1, '45564534', NULL, NULL, NULL),
  (9, 'iqra', 'iqra@gmail.com', '5465', 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 28, NULL, 'http://localhost:8080/images/es2.jpg', 2, '56456', NULL, NULL, NULL),
  (10, 'foodmakernew ', 'foodmakernew@gmail.com', '12395464', '125d6d3b32c84d492747f79cfbf6e179d287f341384eb5d6d3197525ad6be8e6df11632935698f99a09e265073d1d6c32c274591bf1da20ad67cba921bc', 59, NULL, 'http://localhost:8080/images/es2.jpg', 1, '1245788141', NULL, NULL, NULL),
  (11, 'Khizar Jawaid', 'khizarjawaid@gmail.com', '12354644848', '125d6d3b32c84d492747f79cfbf6e179d287f341384eb5d6d3197525ad6be8e6df11632935698f99a09e265073d1d6c32c274591bf1da20ad67cba921bc', 60, 1, 'http://localhost:8080/images/es2.jpg', NULL, '03002289156', NULL, NULL, NULL),
  (12, 'talha', 'zafar@yahoo.com', '789456', 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 61, 1, 'http://localhost:8080/images/es2.jpg', NULL, '03362086168', NULL, NULL, NULL),
  (13, 'malik', 'malikjee@yahoo.com', '456977777', 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 62, NULL, NULL, 1, '03362086168', NULL, NULL, NULL),
  (14, 'ishtiaq', 'iashtiaq@yahoo.com', '111789', 'ba3253876aed6bc22d4a6ff53d846c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 63, NULL, NULL, 1, '03362086168', NULL, NULL, NULL);

/*Table structure for table `lkpt_order_status` */

DROP TABLE IF EXISTS `lkpt_order_status`;

CREATE TABLE `lkpt_order_status` (
  `id`          int(11) NOT NULL AUTO_INCREMENT,
  `discription` varchar(50)      DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `lkpt_order_status` */

/*Table structure for table `locations` */

DROP TABLE IF EXISTS `locations`;

CREATE TABLE `locations` (
  `location_id`  int(11) NOT NULL AUTO_INCREMENT,
  `longitude`    float            DEFAULT NULL,
  `latitude`     float            DEFAULT NULL,
  `foodmaker_id` int(11) NOT NULL,
  PRIMARY KEY (`location_id`),
  KEY `foodmaker_id` (`foodmaker_id`),
  CONSTRAINT `locations_ibfk_1` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = latin1;

/*Data for the table `locations` */

insert into `locations` (`location_id`, `longitude`, `latitude`, `foodmaker_id`)
values (2, 67.0806, 24.842, 8), (3, 67.0813, 24.8418, 2), (4, 67.0502, 24.8369, 9), (5, 67.1154, 24.9012, 6),
  (6, 67.0316, 24.9144, 10), (7, 67.0793, 24.8421, 12), (8, 67.0316, 24.9144, 13), (9, 66.832, 24.8847, 14);

/*Table structure for table `order_dishes` */

DROP TABLE IF EXISTS `order_dishes`;

CREATE TABLE `order_dishes` (
  `orderdishes_id`      int(11) NOT NULL AUTO_INCREMENT,
  `order_id`            int(11)          DEFAULT NULL,
  `foodmaker_dishes_id` int(11)          DEFAULT NULL,
  `quantity`            double           DEFAULT NULL,
  `dishes_dish_id`      int(11)          DEFAULT NULL,
  PRIMARY KEY (`orderdishes_id`),
  KEY `FK_dishes_id` (`foodmaker_dishes_id`),
  KEY `FK_orders_id` (`order_id`),
  KEY `FKfshlrt3cd1fjoywuq1mts2qfx` (`dishes_dish_id`),
  CONSTRAINT `FK5p8h5knoot59tkjy4x9eh41dt` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `FK_foodmaker_dishes_id` FOREIGN KEY (`foodmaker_dishes_id`) REFERENCES `foodmaker_dishes` (`foodmaker_dishes_id`),
  CONSTRAINT `FK_orders_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = latin1;

/*Data for the table `order_dishes` */

insert into `order_dishes` (`orderdishes_id`, `order_id`, `foodmaker_dishes_id`, `quantity`, `dishes_dish_id`)
values (1, 1, 24, 5, NULL);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id`           int(11) NOT NULL AUTO_INCREMENT,
  `customer_id`        int(11)          DEFAULT NULL,
  `reservation_id`     int(11)          DEFAULT NULL,
  `shipment_address`   varchar(50)      DEFAULT NULL,
  `order_date`         datetime         DEFAULT NULL,
  `order_deliver_date` datetime         DEFAULT NULL,
  `order_totalamount`  float            DEFAULT NULL,
  `order_status`       int(11)          DEFAULT NULL,
  `foodmaker_id`       int(11)          DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_customers_id` (`customer_id`),
  KEY `FK_reservations_id` (`reservation_id`),
  KEY `FK1gub01hyim4r0f9bj4x6p1qvy` (`foodmaker_id`),
  CONSTRAINT `FK1gub01hyim4r0f9bj4x6p1qvy` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`),
  CONSTRAINT `FK_customers_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `FK_reservations_id` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`reservation_id`),
  CONSTRAINT `FKpxtb8awmi0dk6smoh2vp1litg` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = latin1;

/*Data for the table `orders` */

insert into `orders` (`order_id`, `customer_id`, `reservation_id`, `shipment_address`, `order_date`, `order_deliver_date`, `order_totalamount`, `order_status`, `foodmaker_id`)
values (1, 10, NULL, 'defence', '2018-03-25 05:00:00', '2018-03-25 05:00:00', 501, 1, 3);

/*Table structure for table `orders_orderdishes` */

DROP TABLE IF EXISTS `orders_orderdishes`;

CREATE TABLE `orders_orderdishes` (
  `order_order_id`             int(11) NOT NULL,
  `orderdishes_orderdishes_id` int(11) NOT NULL,
  UNIQUE KEY `UK_ljsu8q5rmc8bwxlvy7ugblfh7` (`orderdishes_orderdishes_id`),
  KEY `FKsinhp1ujdbp043oeue69xwotq` (`order_order_id`),
  CONSTRAINT `FK3h9hnuwmb5d8ecxe4a7o5erpa` FOREIGN KEY (`orderdishes_orderdishes_id`) REFERENCES `order_dishes` (`orderdishes_id`),
  CONSTRAINT `FKsinhp1ujdbp043oeue69xwotq` FOREIGN KEY (`order_order_id`) REFERENCES `orders` (`order_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `orders_orderdishes` */

/*Table structure for table `payments` */

DROP TABLE IF EXISTS `payments`;

CREATE TABLE `payments` (
  `payment_id`      int(11) NOT NULL AUTO_INCREMENT,
  `order_id`        int(11)          DEFAULT NULL,
  `payment_cleared` int(11)          DEFAULT NULL,
  `payment_date`    datetime         DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE KEY `FK_order_id` (`order_id`),
  CONSTRAINT `FK_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `payments` */

/*Table structure for table `ratings` */

DROP TABLE IF EXISTS `ratings`;

CREATE TABLE `ratings` (
  `rating_id`    int(11) NOT NULL AUTO_INCREMENT,
  `customer_id`  int(11)          DEFAULT NULL,
  `foodmaker_id` int(11)          DEFAULT NULL,
  `stars`        int(11)          DEFAULT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `FK_customerid` (`customer_id`),
  KEY `FK_dishid` (`foodmaker_id`),
  CONSTRAINT `FK_customerid` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `ratings_ibfk_1` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = latin1;

/*Data for the table `ratings` */

insert into `ratings` (`rating_id`, `customer_id`, `foodmaker_id`, `stars`)
values (1, 1, 1, 4), (2, 1, 1, 5), (4, 3, 6, 5), (5, 3, 6, 5), (6, 3, 6, 4);

/*Table structure for table `reservations` */

DROP TABLE IF EXISTS `reservations`;

CREATE TABLE `reservations` (
  `reservation_id`     int(11) NOT NULL AUTO_INCREMENT,
  `foodmaker_id`       int(11)          DEFAULT NULL,
  `rider_id`           int(11)          DEFAULT NULL,
  `reservation_date`   date             DEFAULT NULL,
  `reservation_status` int(11)          DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `FK_foodmakerid` (`foodmaker_id`),
  KEY `FK_riders_id` (`rider_id`),
  CONSTRAINT `FK_foodmakerid` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`),
  CONSTRAINT `FK_riders_id` FOREIGN KEY (`rider_id`) REFERENCES `riders` (`rider_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `reservations` */

/*Table structure for table `riders` */

DROP TABLE IF EXISTS `riders`;

CREATE TABLE `riders` (
  `rider_id`          int(11)   NOT NULL AUTO_INCREMENT,
  `rider_name`        varchar(15)        DEFAULT NULL,
  `rider_nic`         varchar(15)        DEFAULT NULL,
  `rider_password`    varchar(300)       DEFAULT NULL,
  `rider_accesstype`  int(11)            DEFAULT NULL,
  `rider_phonenumber` varchar(15)        DEFAULT NULL,
  `address_id`        int(11)            DEFAULT NULL,
  `rider_imagepath`   varchar(50)        DEFAULT NULL,
  `rider_active`      int(11)            DEFAULT NULL,
  `admin_id`          int(11)            DEFAULT NULL,
  `vehicle_id`        int(11)            DEFAULT NULL,
  `rider_createdat`   datetime           DEFAULT NULL,
  `rider_lastupdated` timestamp NULL     DEFAULT NULL,
  `location_id`       int(11)            DEFAULT NULL,
  `rider_email`       varchar(25)        DEFAULT NULL,
  PRIMARY KEY (`rider_id`),
  UNIQUE KEY `FK_loca_id` (`location_id`),
  UNIQUE KEY `FK_addresss_id` (`address_id`),
  UNIQUE KEY `FK_vehicles_id` (`vehicle_id`),
  UNIQUE KEY `rider_email` (`rider_email`),
  UNIQUE KEY `rider_nic` (`rider_nic`),
  UNIQUE KEY `EMAIL_INDEX` (`rider_email`, `rider_nic`),
  KEY `FK_adminsid` (`admin_id`),
  CONSTRAINT `FK_addresss_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FK_adminsid` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`admin_id`),
  CONSTRAINT `FK_loca_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`),
  CONSTRAINT `FK_vehicles_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`),
  CONSTRAINT `FKddximr9src80d6a6u8lfsr22t` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`address_id`),
  CONSTRAINT `FKt4uavxvpgjt51k8okavsy3b9s` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`vehicle_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = latin1;

/*Data for the table `riders` */

insert into `riders` (`rider_id`, `rider_name`, `rider_nic`, `rider_password`, `rider_accesstype`, `rider_phonenumber`, `address_id`, `rider_imagepath`, `rider_active`, `admin_id`, `vehicle_id`, `rider_createdat`, `rider_lastupdated`, `location_id`, `rider_email`)
values (1, 'ali', '1564564', NULL, 1, '05185155', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ali@gmail.com');

/*Table structure for table `updatedishes` */

DROP TABLE IF EXISTS `updatedishes`;

CREATE TABLE `updatedishes` (
  `updatedishes_id` int(11) NOT NULL AUTO_INCREMENT,
  `foodmaker_id`    int(11)          DEFAULT NULL,
  `dish_id`         int(11)          DEFAULT NULL,
  `dish_amount`     double           DEFAULT NULL,
  PRIMARY KEY (`updatedishes_id`),
  KEY `FK_fmaker_id` (`foodmaker_id`),
  KEY `FK_did` (`dish_id`),
  CONSTRAINT `FK_did` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`dish_id`),
  CONSTRAINT `FK_fmaker_id` FOREIGN KEY (`foodmaker_id`) REFERENCES `foodmakers` (`foodmaker_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `updatedishes` */

/*Table structure for table `vehicles` */

DROP TABLE IF EXISTS `vehicles`;

CREATE TABLE `vehicles` (
  `vehicle_id`     int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_number` varchar(15)      DEFAULT NULL,
  `vehicle_name`   varchar(15)      DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

/*Data for the table `vehicles` */

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
