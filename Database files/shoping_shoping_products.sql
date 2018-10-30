-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shoping
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shoping_products`
--

DROP TABLE IF EXISTS `shoping_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shoping_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `amount` int(4) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  `onPurchase` varchar(10) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_toShops_idx` (`shop_id`),
  CONSTRAINT `FK_toShops` FOREIGN KEY (`shop_id`) REFERENCES `shoping_shops` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoping_products`
--

LOCK TABLES `shoping_products` WRITE;
/*!40000 ALTER TABLE `shoping_products` DISABLE KEYS */;
INSERT INTO `shoping_products` VALUES (1,'Pienas',2,0,1,'2018.10.17'),(2,'Duona',1,0,5,'2018.10.17'),(3,'Kiausiniai',1,0,1,'2018.10.17'),(5,'Lasisa',1,0,2,'2018.10.17'),(7,'Miltai',2,0,2,'0'),(8,'Varske',3,0,2,'0'),(10,'Kompiuteris',1,2,5,'2018.10.17'),(11,'Stalas',1,1,1,'2018.10.18'),(13,'Arbuzas',1,0,2,'0');
/*!40000 ALTER TABLE `shoping_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-30 18:51:33
