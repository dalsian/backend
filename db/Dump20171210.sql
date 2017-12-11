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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `layout_template`
--

LOCK TABLES `layout_template` WRITE;
/*!40000 ALTER TABLE `layout_template` DISABLE KEYS */;
INSERT INTO `layout_template` VALUES (1,'Dalby Hall',500,200);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'American Pie','Comedy','afesf',165,NULL),(2,'Inception','Scifi','jlkl l jl j;lj ',120,NULL);
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
  CONSTRAINT `fk_schedule_movie` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2017-12-12 04:20:00',1,1,NULL),(2,'2017-12-13 03:30:00',1,1,NULL),(3,'2017-12-24 05:30:00',2,1,NULL),(4,'2017-12-25 09:30:00',2,1,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_occupancy`
--

LOCK TABLES `seat_occupancy` WRITE;
/*!40000 ALTER TABLE `seat_occupancy` DISABLE KEYS */;
INSERT INTO `seat_occupancy` VALUES (1,'free',NULL,NULL,1,1),(2,'sold','2017-12-09 22:48:19','1',1,2),(3,'sold','2017-12-09 22:48:19','1',1,3),(4,'sold','2017-12-09 22:48:19','1',1,4),(5,'free',NULL,NULL,1,5),(6,'free',NULL,NULL,1,6),(7,'free',NULL,NULL,1,7),(8,'free',NULL,NULL,1,8),(9,'free',NULL,NULL,2,1),(10,'free',NULL,NULL,2,2),(11,'free',NULL,NULL,2,3),(12,'free',NULL,NULL,2,4),(13,'free',NULL,NULL,2,5),(14,'free',NULL,NULL,2,6),(15,'free',NULL,NULL,2,7),(16,'free',NULL,NULL,2,8),(17,'free',NULL,NULL,3,1),(18,'free',NULL,NULL,3,2),(19,'free',NULL,NULL,3,3),(20,'free',NULL,NULL,3,4),(21,'free',NULL,NULL,3,5),(22,'free',NULL,NULL,3,6),(23,'free',NULL,NULL,3,7),(24,'free',NULL,NULL,3,8);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_template`
--

LOCK TABLES `seat_template` WRITE;
/*!40000 ALTER TABLE `seat_template` DISABLE KEYS */;
INSERT INTO `seat_template` VALUES (1,'A',0,1,1),(2,'A',0,2,1),(3,'A',0,3,1),(4,'B',0,4,2),(5,'B',0,5,2),(6,'B',0,6,2),(7,'C',0,7,3),(8,'C',0,8,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_price`
--

LOCK TABLES `section_price` WRITE;
/*!40000 ALTER TABLE `section_price` DISABLE KEYS */;
INSERT INTO `section_price` VALUES (1,20,NULL,1,1),(2,15,NULL,1,2),(3,15,NULL,1,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section_template`
--

LOCK TABLES `section_template` WRITE;
/*!40000 ALTER TABLE `section_template` DISABLE KEYS */;
INSERT INTO `section_template` VALUES (1,'Middle',100,10,500,100,'#FFFEEE',1),(2,'Left',10,10,400,80,'#FEE333',1),(3,'Right',200,100,400,80,'#AEE342',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,'GENERATED','A2',20,1,1,1),(2,'GENERATED','A3',20,1,1,1),(3,'GENERATED','B1',20,1,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_order`
--

LOCK TABLES `ticket_order` WRITE;
/*!40000 ALTER TABLE `ticket_order` DISABLE KEYS */;
INSERT INTO `ticket_order` VALUES (1,'GENERATED','2017-12-09 22:48:20',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tester','Testable','1990-08-08','143543','tester','password',1,NULL),(2,'Dalsian','Mung','1990-08-08','11223344','dalsian','verysecure',0,NULL),(13,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',0,NULL),(14,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',1,NULL),(15,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',1,NULL),(16,'Snowman','Santa',NULL,'911','snow','****** need to hash password *******',1,NULL);
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

-- Dump completed on 2017-12-10 19:22:57
