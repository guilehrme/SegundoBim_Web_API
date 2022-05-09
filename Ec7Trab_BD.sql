-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: trabec7
-- ------------------------------------------------------
-- Server version	8.0.29

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

--
-- Table structure for table `pilotos`
--

DROP TABLE IF EXISTS `pilotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pilotos` (
  `nomePiloto` varchar(255) NOT NULL,
  PRIMARY KEY (`nomePiloto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilotos`
--

LOCK TABLES `pilotos` WRITE;
/*!40000 ALTER TABLE `pilotos` DISABLE KEYS */;
INSERT INTO `pilotos` VALUES ('Alexander Albon'),('Carlos Sainz'),('Charles Leclerc'),('Daniel Ricciardo'),('Esteban Ocon'),('Fernando Alonso'),('George Russell'),('Guanyu Zhou'),('Kevin Magnussen'),('Lance Stroll'),('Lando Norris'),('Lewis Hamilton'),('Max Verstappen'),('Mick Schumacher'),('Nico Hulkenberg'),('Nicolas Latifi'),('Pierre Gasly'),('Sebastian Vettel'),('Sergio Pérez'),('Valtteri Bottas'),('Yuki Tsunoda');
/*!40000 ALTER TABLE `pilotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `nomeUser` varchar(255) NOT NULL,
  `PilotoFav1` varchar(255) DEFAULT NULL,
  `PilotoFav2` varchar(255) DEFAULT NULL,
  `PilotoFav3` varchar(255) DEFAULT NULL,
  `idUser` varchar(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `nomeUser_UNIQUE` (`nomeUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('TesteGet',NULL,NULL,NULL,'1'),('Guilherme',NULL,NULL,NULL,'2'),('Claudio',NULL,NULL,NULL,'3');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'trabec7'
--

--
-- Dumping routines for database 'trabec7'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-09 12:05:22
