-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: localhost    Database: dell
-- ------------------------------------------------------
-- Server version	8.0.19-0ubuntu0.19.10.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `huawei`
--

DROP TABLE IF EXISTS `huawei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `huawei` (
  `id` int NOT NULL AUTO_INCREMENT,
  `personID` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `personID` (`personID`),
  CONSTRAINT `huawei_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `huawei`
--

LOCK TABLES `huawei` WRITE;
/*!40000 ALTER TABLE `huawei` DISABLE KEYS */;
INSERT INTO `huawei` VALUES (1,3,10),(2,8,32),(3,10,33),(4,7,77),(5,3,277),(6,5,1),(7,6,400);
/*!40000 ALTER TABLE `huawei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'FUCK YOU',
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created` date DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Hein Zaw Aung','heinzawaung1301@gmail.com',NULL,'2018-07-20 05:30:34',NULL),(2,'Khaing ThaZin',NULL,NULL,'2018-07-20 05:30:34',NULL),(3,'Su Thet Paing',NULL,NULL,'2018-07-20 05:30:34',NULL),(4,'InGyin Khaing',NULL,NULL,'2018-07-20 05:30:34',NULL),(5,'Ei Ei','barbie528@gmail.com','2019-03-31','2018-07-20 05:30:34',NULL),(6,'Zin Min Phyo','zinminphyo234@gmail.com','2020-01-12','2018-07-20 05:30:34',NULL),(7,'Nyein Nyein','nyein@gmail.com','2019-08-22','2018-07-20 05:30:34',NULL),(8,'Wai Phue','waiphue@gmail.com','2020-04-14','2018-07-20 05:30:34',NULL),(9,'Ei Phway','eiphway12@hotmail.com','2015-03-21','2020-04-14 19:00:13',NULL),(10,'Chaw Su Win','chawsu@yahoo.com','2020-04-14','2020-04-14 19:18:47','2020-04-14 12:48:47');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-15 19:49:56
