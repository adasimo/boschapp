
--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto` CASCADE;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!SET character_set_client = utf8mb4 ;*/
CREATE TABLE `auto` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `megnevezes` varchar(40),
  PRIMARY KEY (`id`)
) /*!ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

/*!LOCK TABLES `auto` WRITE;*/
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'Ford Mondeo'),(2,'Skoda Octavia'),(3,'Kia Ceed');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
/*!UNLOCK TABLES;*/

--
-- Table structure for table `auto_eletkor`
--

DROP TABLE IF EXISTS `auto_eletkor`  CASCADE;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!SET character_set_client = utf8mb4 ;*/
CREATE TABLE `auto_eletkor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `megnevezes` varchar(50),
  PRIMARY KEY (`id`)
  /*!CHECK (megnevezes IN ('0-5', '5-10', '10+')*/
) /*!ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto_eletkor`
--

/*!LOCK TABLES `auto_eletkor` WRITE;*/
/*!40000 ALTER TABLE `auto_eletkor` DISABLE KEYS */;
INSERT INTO `auto_eletkor` VALUES (1,'0-5'),(2,'5-10'),(3,'10+');
/*!40000 ALTER TABLE `auto_eletkor` ENABLE KEYS */;
/*!UNLOCK TABLES;*/

--
-- Table structure for table `szervizkonyv`
--

DROP TABLE IF EXISTS `szervizkonyv`  CASCADE;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!SET character_set_client = utf8mb4 ;*/
CREATE TABLE `szervizkonyv` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tulajdonos` varchar(50) NOT NULL,
  `auto` int(10) NOT NULL,
  `garancialis` tinyint(1),
  `eletkor` int(10) NOT NULL,
  `szerviz_kezdete` TIMESTAMP NOT NULL,
  `szerviz_vege` TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`auto`) REFERENCES `auto`(`id`),
  FOREIGN KEY (`eletkor`) REFERENCES `auto_eletkor`(`id`)
) /*!ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `szervizkonyv`
--

/*!LOCK TABLES `szervizkonyv` WRITE;*/
/*!40000 ALTER TABLE `szervizkonyv` DISABLE KEYS */;
INSERT INTO `szervizkonyv` VALUES (1,'Kovács Béla',1,1,1,'2021-03-09 11:29:58.97077',NULL),(2,'Nagy József',2,0,2,'2021-02-01 13:29:58.97077',NULL),(3,'Kiss Sándor',3,1,3,'2020-03-09 01:29:58.97077','2020-05-09 15:29:58.97077');
/*!40000 ALTER TABLE `szervizkonyv` ENABLE KEYS */;
/*!UNLOCK TABLES;*/
