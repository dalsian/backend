CREATE DATABASE  IF NOT EXISTS `cinematicketing` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cinematicketing`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cinematicketing
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `layout_template`
--

DROP TABLE IF EXISTS `layout_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layout_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layout_template`
--

LOCK TABLES `layout_template` WRITE;
/*!40000 ALTER TABLE `layout_template` DISABLE KEYS */;
INSERT INTO `layout_template` VALUES (1,'Dalby Hall',500,2000),(2,'Festival Hall',500,500);
/*!40000 ALTER TABLE `layout_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `layout_template_section_template`
--

DROP TABLE IF EXISTS `layout_template_section_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `layout_template_section_template` (
  `layout_template_id` bigint(20) NOT NULL,
  `sectionTemplateList_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_5gnw2vgadjge883o25ud9md8t` (`sectionTemplateList_id`),
  KEY `FKgjtsmvi4o7tfcui39vruwuy32` (`layout_template_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layout_template_section_template`
--

LOCK TABLES `layout_template_section_template` WRITE;
/*!40000 ALTER TABLE `layout_template_section_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `layout_template_section_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `description` text,
  `length` int(11) DEFAULT NULL,
  `imageurl` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'The Matrix','Comedy','Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix? Neo is contacted by Trinity (Carrie-Anne Moss), a beautiful stranger who leads him into an underworld where he meets Morpheus. They fight a brutal battle for their lives against a cadre of viciously intelligent secret agents. It is a truth that could cost Neo something more precious than his life.',165,'/org/mum/assets/img/the_matrix.jpg'),(3,'Avatar (3D)','4','On the lush alien world of Pandora live the Na\'vi, beings who appear primitive but are highly evolved. Because the planet\'s environment is poisonous, human/Na\'vi hybrids, called Avatars, must link to human minds to allow for free movement on Pandora. Jake Sully (Sam Worthington), a paralyzed former Marine, becomes mobile again through one such Avatar and falls in love with a Na\'vi woman (Zoe Saldana). As a bond with her grows, he is drawn into a battle for the survival of her world.',210,'/org/mum/assets/img/avatar.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_schedule`
--

DROP TABLE IF EXISTS `movie_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_schedule` (
  `movie_id` bigint(20) NOT NULL,
  `scheduleList_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_6ivjjuy5te5wkahqdw9enstgr` (`scheduleList_id`),
  KEY `FKiphejm916oqwk9fodldpacxch` (`movie_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_schedule`
--

LOCK TABLES `movie_schedule` WRITE;
/*!40000 ALTER TABLE `movie_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_ticket`
--

DROP TABLE IF EXISTS `order_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_ticket` (
  `order_id` bigint(20) NOT NULL,
  `ticketList_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_nstr6dal3ua0jyj53ix5v01p6` (`ticketList_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_ticket`
--

LOCK TABLES `order_ticket` WRITE;
/*!40000 ALTER TABLE `order_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datetime` datetime DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `layout_template_id` int(11) DEFAULT NULL,
  `layoutTemplate_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_schedule_movie_idx` (`movie_id`),
  KEY `fk_schedule_layout_template_idx` (`layout_template_id`),
  CONSTRAINT `fk_schedule_layout_template` FOREIGN KEY (`layout_template_id`) REFERENCES `layout_template` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2017-12-12 04:20:00',1,1,NULL),(2,'2017-12-13 03:30:00',1,1,NULL),(19,'2017-12-14 12:20:00',1,1,NULL),(20,'2017-12-30 03:30:00',3,2,NULL),(21,'2017-12-25 10:30:00',1,2,NULL),(22,'2017-12-25 10:30:00',1,2,NULL),(23,'2017-12-28 09:30:00',1,2,NULL),(24,'2017-12-16 02:30:00',1,2,NULL),(25,'2017-12-29 12:00:00',1,2,NULL);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_section_price`
--

DROP TABLE IF EXISTS `schedule_section_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_section_price` (
  `schedule_id` bigint(20) NOT NULL,
  `sectionPriceList_id` bigint(20) NOT NULL,
  PRIMARY KEY (`schedule_id`,`sectionPriceList_id`),
  UNIQUE KEY `UK_2fiasa54ktrv3pafloclk3sfm` (`sectionPriceList_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_section_price`
--

LOCK TABLES `schedule_section_price` WRITE;
/*!40000 ALTER TABLE `schedule_section_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_section_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_occupancy`
--

DROP TABLE IF EXISTS `seat_occupancy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat_occupancy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  `locked_time` datetime DEFAULT NULL,
  `locked_by` varchar(45) DEFAULT NULL,
  `section_price_id` int(11) DEFAULT NULL,
  `seat_template_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_seat_occupancy_section_price_idx` (`section_price_id`),
  KEY `fk_seat_occupancy_seat_template_idx` (`seat_template_id`),
  CONSTRAINT `fk_seat_occupancy_seat_template` FOREIGN KEY (`seat_template_id`) REFERENCES `seat_template` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_seat_occupancy_section_price` FOREIGN KEY (`section_price_id`) REFERENCES `section_price` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_occupancy`
--

LOCK TABLES `seat_occupancy` WRITE;
/*!40000 ALTER TABLE `seat_occupancy` DISABLE KEYS */;
INSERT INTO `seat_occupancy` VALUES (1,'1',NULL,NULL,1,1),(2,'0',NULL,NULL,1,2),(3,'1',NULL,NULL,1,3),(4,'0',NULL,NULL,1,4),(5,'0',NULL,NULL,1,5),(6,'0',NULL,NULL,1,6),(7,'0',NULL,NULL,1,7),(8,'0',NULL,NULL,1,8),(9,'1',NULL,NULL,2,1),(10,'0',NULL,NULL,2,2),(11,'1',NULL,NULL,2,3),(12,'0',NULL,NULL,2,4),(13,'0',NULL,NULL,2,5),(14,'0',NULL,NULL,2,6),(15,'0',NULL,NULL,2,7),(16,'0',NULL,NULL,2,8),(17,'1',NULL,NULL,3,1),(18,'0',NULL,NULL,3,2),(19,'0',NULL,NULL,3,3),(20,'0',NULL,NULL,3,4),(21,'0',NULL,NULL,3,5),(22,'0',NULL,NULL,3,6),(23,'0',NULL,NULL,3,7),(24,'0',NULL,NULL,3,8),(25,'0',NULL,NULL,18,7),(26,'0',NULL,NULL,18,8),(27,'0',NULL,NULL,17,1),(28,'0',NULL,NULL,17,2),(29,'0',NULL,NULL,17,3),(30,'0',NULL,NULL,16,4),(31,'1',NULL,NULL,16,5),(32,'0',NULL,NULL,16,6),(33,'1',NULL,NULL,22,9),(34,'0',NULL,NULL,22,10),(35,'0',NULL,NULL,22,11),(36,'0',NULL,NULL,22,12),(37,'0',NULL,NULL,22,13),(38,'0',NULL,NULL,22,14),(39,'0',NULL,NULL,22,15),(40,'0',NULL,NULL,22,16),(41,'0',NULL,NULL,22,17),(42,'0',NULL,NULL,22,18),(43,'0',NULL,NULL,22,19),(44,'0',NULL,NULL,22,20),(45,'0',NULL,NULL,24,9),(46,'0',NULL,NULL,24,10),(47,'0',NULL,NULL,24,11),(48,'0',NULL,NULL,24,12),(49,'0',NULL,NULL,24,13),(50,'0',NULL,NULL,24,14),(51,'0',NULL,NULL,24,15),(52,'0',NULL,NULL,24,16),(53,'0',NULL,NULL,24,17),(54,'0',NULL,NULL,24,18),(55,'0',NULL,NULL,24,19),(56,'0',NULL,NULL,24,20),(57,'0',NULL,NULL,26,9),(58,'0',NULL,NULL,26,10),(59,'0',NULL,NULL,26,11),(60,'0',NULL,NULL,26,12),(61,'0',NULL,NULL,26,13),(62,'0',NULL,NULL,26,14),(63,'0',NULL,NULL,26,15),(64,'0',NULL,NULL,26,16),(65,'0',NULL,NULL,26,17),(66,'0',NULL,NULL,26,18),(67,'0',NULL,NULL,26,19),(68,'0',NULL,NULL,26,20),(69,'0',NULL,NULL,28,9),(70,'0',NULL,NULL,28,10),(71,'0',NULL,NULL,28,11),(72,'0',NULL,NULL,28,12),(73,'0',NULL,NULL,28,13),(74,'0',NULL,NULL,28,14),(75,'0',NULL,NULL,28,15),(76,'0',NULL,NULL,28,16),(77,'0',NULL,NULL,28,17),(78,'0',NULL,NULL,28,18),(79,'0',NULL,NULL,28,19),(80,'0',NULL,NULL,28,20),(81,'0',NULL,NULL,30,9),(82,'0',NULL,NULL,30,10),(83,'0',NULL,NULL,30,11),(84,'0',NULL,NULL,30,12),(85,'0',NULL,NULL,30,13),(86,'0',NULL,NULL,30,14),(87,'0',NULL,NULL,30,15),(88,'0',NULL,NULL,30,16),(89,'0',NULL,NULL,30,17),(90,'0',NULL,NULL,30,18),(91,'0',NULL,NULL,30,19),(92,'0',NULL,NULL,30,20),(93,'0',NULL,NULL,32,9),(94,'0',NULL,NULL,32,10),(95,'0',NULL,NULL,32,11),(96,'0',NULL,NULL,32,12),(97,'0',NULL,NULL,32,13),(98,'0',NULL,NULL,32,14),(99,'0',NULL,NULL,32,15),(100,'0',NULL,NULL,32,16),(101,'0',NULL,NULL,32,17),(102,'0',NULL,NULL,32,18),(103,'0',NULL,NULL,32,19),(104,'0',NULL,NULL,32,20);
/*!40000 ALTER TABLE `seat_occupancy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_template`
--

DROP TABLE IF EXISTS `seat_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seat_label` varchar(45) NOT NULL,
  `pos_x` int(11) DEFAULT NULL,
  `pos_y` int(11) DEFAULT NULL,
  `section_template_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_seat_template_section_template_idx` (`section_template_id`),
  CONSTRAINT `fk_seat_template_section_template` FOREIGN KEY (`section_template_id`) REFERENCES `section_template` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_template`
--

LOCK TABLES `seat_template` WRITE;
/*!40000 ALTER TABLE `seat_template` DISABLE KEYS */;
INSERT INTO `seat_template` VALUES (1,'A',0,1,1),(2,'A',0,2,1),(3,'A',0,3,1),(4,'B',0,4,2),(5,'B',0,5,2),(6,'B',0,6,2),(7,'C',0,7,3),(8,'C',0,8,3),(9,'A',0,1,4),(10,'A',0,2,4),(11,'A',0,3,4),(12,'B',0,1,4),(13,'B',0,2,4),(14,'B',0,3,4),(15,'C',0,1,4),(16,'C',0,2,4),(17,'C',0,3,4),(18,'D',0,1,4),(19,'D',0,2,4),(20,'D',0,3,4);
/*!40000 ALTER TABLE `seat_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_price`
--

DROP TABLE IF EXISTS `section_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,0) DEFAULT NULL,
  `section_label` varchar(45) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `section_template_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_section_price_schedule_idx` (`schedule_id`),
  KEY `fk_section_price_section_template_idx` (`section_template_id`),
  CONSTRAINT `fk_section_price_schedule` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_price_section_template` FOREIGN KEY (`section_template_id`) REFERENCES `section_template` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_price`
--

LOCK TABLES `section_price` WRITE;
/*!40000 ALTER TABLE `section_price` DISABLE KEYS */;
INSERT INTO `section_price` VALUES (1,20,'Default',1,1),(2,15,'Default',1,2),(3,15,'Default',1,3),(4,20,'Special',2,1),(5,20,'Special',2,2),(6,25,'Special',2,3),(7,50,'VIP',1,4),(16,10,'Left',19,2),(17,12,'Middle',19,1),(18,10,'Right',19,3),(19,10,'Right',19,3),(20,12,'Middle',19,1),(21,10,'Left',19,2),(22,50,'Mid',20,4),(23,50,'Mid',20,4),(24,20,'Mid',21,4),(25,20,'Mid',21,4),(26,12,'Mid',22,4),(27,12,'Mid',22,4),(28,15,'Mid',23,4),(29,15,'Mid',23,4),(30,14,'Mid',24,4),(31,14,'Mid',24,4),(32,34,'Mid',25,4),(33,34,'Mid',25,4);
/*!40000 ALTER TABLE `section_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section_template`
--

DROP TABLE IF EXISTS `section_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `section_label` varchar(45) NOT NULL,
  `pos_x` int(11) DEFAULT NULL,
  `pos_y` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `layout_template_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_section_template_layout_template_idx` (`layout_template_id`),
  CONSTRAINT `fk_section_template_layout_template` FOREIGN KEY (`layout_template_id`) REFERENCES `layout_template` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_template`
--

LOCK TABLES `section_template` WRITE;
/*!40000 ALTER TABLE `section_template` DISABLE KEYS */;
INSERT INTO `section_template` VALUES (1,'Middle',100,10,500,100,'#FFFEEE',1),(2,'Left',10,10,400,80,'#FEE333',1),(3,'Right',200,100,400,80,'#AEE342',1),(4,'Mid',0,0,0,0,'#FFFEEE',2);
/*!40000 ALTER TABLE `section_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_number` varchar(45) NOT NULL,
  `seat_label` varchar(45) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `schedule_id` int(11) DEFAULT NULL,
  `section_price_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_schedule_idx` (`schedule_id`),
  KEY `fk_ticket_section_price_idx` (`section_price_id`),
  KEY `fk_ticket_order_idx` (`order_id`),
  CONSTRAINT `fk_ticket_order` FOREIGN KEY (`order_id`) REFERENCES `ticket_order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_schedule` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_section_price` FOREIGN KEY (`section_price_id`) REFERENCES `section_price` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'GENERATED','A2',20,1,1,1),(2,'GENERATED','A3',20,1,1,1),(3,'GENERATED','B1',20,1,1,1),(4,'T-20171112-1513125004472','A',15,1,3,6),(5,'T-20171112-1513125006999','A',15,1,2,6),(6,'T-20171112-1513125180489','A',15,1,2,7),(7,'T-20171112-1513125180493','A',20,1,1,7),(8,'T-20171112-1513125517588','A',20,1,1,8),(9,'T-20171113-1513145120767','A',50,20,22,9),(10,'T-20171113-1513148501943','B',10,19,16,10);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_order`
--

DROP TABLE IF EXISTS `ticket_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(45) NOT NULL,
  `order_datetime` datetime DEFAULT NULL,
  `total_price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_order`
--

LOCK TABLES `ticket_order` WRITE;
/*!40000 ALTER TABLE `ticket_order` DISABLE KEYS */;
INSERT INTO `ticket_order` VALUES (1,'GENERATED','2017-12-09 22:48:20',0),(2,'O-20171112-1513123563309','2017-12-12 18:06:03',0),(4,'O-20171112-1513123988252','2017-12-12 18:13:08',0),(5,'O-20171112-1513124176439','2017-12-12 18:16:17',0),(6,'O-20171112-1513124992204','2017-12-12 18:29:53',0),(7,'O-20171112-1513125180455','2017-12-12 18:33:00',0),(8,'O-20171112-1513125517522','2017-12-12 18:38:38',0),(9,'O-20171113-1513145120743','2017-12-13 00:05:21',0),(10,'O-20171113-1513148501923','2017-12-13 01:01:42',0);
/*!40000 ALTER TABLE `ticket_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `user_id` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role_type` int(11) DEFAULT '1',
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tester','Testable','1990-08-08','143543','tester','password',1,NULL),(2,'Dalsian','Mung','1990-08-08','11223344','dalsian','21232F297A57A5A743894A0E4A801FC3',1,NULL),(13,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',0,NULL),(14,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',1,NULL),(15,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',1,NULL),(16,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',1,NULL),(17,'Someoneelse','Hello',NULL,NULL,'world','****** need to hash password *******',1,NULL),(18,'Someoneelse','Hello',NULL,NULL,'world','[B@135fbaa4',1,NULL),(19,'Someoneelse','Hello',NULL,NULL,'world','[B@266474c2',1,NULL),(20,'Someoneelse','Hello',NULL,NULL,'world','[B@266474c2',1,NULL),(21,'Someoneelse','Hello',NULL,NULL,'world','798AFDE7743793490C02D36695EEF82B',1,NULL),(22,'Someoneelse','Hello',NULL,NULL,'admin','21232F297A57A5A743894A0E4A801FC3',0,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13  1:02:08
