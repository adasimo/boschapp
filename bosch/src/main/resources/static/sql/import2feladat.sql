/*CREATE DATABASE IF NOT EXISTS `cs_beugro` 40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;*/
/*USE `cs_beugro`;*/
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: htvvm592    Database: cs_beugro
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car` CASCADE;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!SET character_set_client = utf8mb4 ;*/
CREATE TABLE `car` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) /*!ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

/*!LOCK TABLES `car` WRITE;*/
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'Opel','Vectra'),(2,'Opel','Astra'),(3,'Fiat','126'),(4,'Fiat','Seicento'),(5,'Suzuki','Swift'),(6,'Ford','Focus'),(7,'Ford','Mondeo');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
/*!UNLOCK TABLES;*/

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user` CASCADE;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*! SET character_set_client = utf8mb4 ;*/
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) /*!ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

/*!LOCK TABLES `user` WRITE;*/
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kozma Imre'),(2,'Máté Benjamin'),(3,'Miksa Ármin'),(4,'Oláh Adrián'),(5,'Lakatos Kevin'),(6,'Kovács Erik'),(7,'Kis Domonkos'),(8,'Borbély Valentin'),(9,'Zobor Rudolf'),(10,'Faragó Gergo'),(11,'Molnár Alexander'),(12,'Bács Zsombor'),(13,'Varga Bendegúz'),(14,'Szilágyi Bertalan'),(15,'Dudás Ferenc'),(16,'Mezei Nándor'),(17,'Soós Gyula'),(18,'Váradi Jakab'),(19,'Balázs Szilveszter'),(20,'Hajdú Benjámin'),(21,'Orosz Róbert'),(22,'Kerekes László'),(23,'Kende Áron'),(24,'Takács Martin'),(25,'Tamás Vilmos'),(26,'Lakatos Miklós'),(27,'Apród Barna'),(28,'Balázs Norbert'),(29,'Péter Donát'),(30,'Barta Noel'),(31,'Egyed Ármin'),(32,'Novák Benedek'),(33,'Tamás Csanád'),(34,'Soós Antal'),(35,'Bakos Barnabás'),(36,'Gáspár Levente'),(37,'Simon András'),(38,'Balogh Kálmán'),(39,'Fülöp Krisztián'),(40,'Budai Jakab');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!UNLOCK TABLES;*/

--
-- Table structure for table `user_car`
--

DROP TABLE IF EXISTS `user_car` CASCADE;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!SET character_set_client = utf8mb4 ;*/
CREATE TABLE `user_car` (
  `user` int(10) NOT NULL,
  `car` int(10) NOT NULL,
  KEY `FK_user_id_idx` (`user`),
  KEY `FK_car_id_idx` (`car`),
  CONSTRAINT `FK_car_id` FOREIGN KEY (`car`) REFERENCES `car` (`id`),
  CONSTRAINT `FK_user_id` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
)/*! ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_car`
--

/*!LOCK TABLES `user_car` WRITE;*/
/*!40000 ALTER TABLE `user_car` DISABLE KEYS */;
INSERT INTO `user_car` VALUES (1,2),(1,4),(1,6),(2,5),(3,1),(3,3),(4,2),(5,1),(5,5),(6,7),(8,2),(10,4),(11,4),(12,2),(13,3),(14,2),(15,5),(17,6),(18,2),(19,3),(20,4),(21,7),(22,2),(23,2),(25,1),(25,2),(26,6),(28,5),(29,3),(30,3),(31,1),(32,3),(33,5),(34,1),(35,3),(37,7),(38,4),(39,4),(40,2);
/*!40000 ALTER TABLE `user_car` ENABLE KEYS */;
/*!UNLOCK TABLES;*/
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-09 10:49:49
