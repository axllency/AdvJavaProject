-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: aa5a174hjgl1wx.cjg8umpamjmd.us-east-2.rds.amazonaws.com    Database: ebdb
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `vinyl`
--

DROP TABLE IF EXISTS `vinyl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinyl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `album_title` varchar(255) DEFAULT NULL,
  `artist` varchar(255) DEFAULT NULL,
  `record_condition` varchar(255) DEFAULT NULL,
  `record_label` varchar(255) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `serial_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinyl`
--

LOCK TABLES `vinyl` WRITE;
/*!40000 ALTER TABLE `vinyl` DISABLE KEYS */;
INSERT INTO `vinyl` VALUES (1,'testAlbum','testArtist','New','TheTestRecordLabel','12/1/2020','56fh'),(2,'testAlbum2','testArtist2','Old','TheTestRecordLabel','12/2/2020','hg78'),(3,'testAlbumw2321','testArtist324','Broken','TheTestRecordLabel234','12/1/2020','56fh234'),(5,'PostUpdate_01','UpdatedARtist','Old','PostTest_01','1/1/99','TPM1'),(6,'PostTest_01','PostTest_01','New','PostTest_01','1/1/00','TPM1'),(7,'UpdateDeleteTest_01','UpdateDeleteTest_01','New','UpdateDeleteTest_01','1/1/00','TUD1'),(10,'UpdateSuccess','UpdateSuccess','New','UpdateSuccess','1/1/00','TUD1'),(16,'testingnow123456','ppel','New','ghj78','2020-12-16','fgh56'),(20,'classDemonstration','me','New',NULL,'2020-12-16','asdflkj'),(22,'PostTest_01','PostTest_01','New','PostTest_01','1/1/00','TPM1');
/*!40000 ALTER TABLE `vinyl` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-17 20:54:49
