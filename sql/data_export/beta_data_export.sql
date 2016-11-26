-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: matrix
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Dumping data for table `pontuacoes`
--

LOCK TABLES `pontuacoes` WRITE;
/*!40000 ALTER TABLE `pontuacoes` DISABLE KEYS */;
INSERT INTO `pontuacoes` VALUES (1,''),(2,'.'),(3,','),(4,';'),(5,'-'),(6,':'),(7,'('),(8,')'),(9,'['),(10,']'),(11,'{'),(12,'}'),(13,'!'),(14,'?'),(15,'!!!'),(16,'???'),(17,'!?!'),(18,'...'),(19,'ï¿½'),(20,'Ã©'),(21,'Ã?'),(22,'Ã£'),(23,'Ãª'),(24,'Ã­'),(25,'Ã '),(26,'Ã¡'),(27,'ï¿½!'),(28,'Ã©.'),(29,'Ã©'),(30,'Ãª'),(31,'Ãª?'),(32,'Ã³'),(33,'Ã©,'),(34,'Ãª');
/*!40000 ALTER TABLE `pontuacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sugestores`
--

LOCK TABLES `sugestores` WRITE;
/*!40000 ALTER TABLE `sugestores` DISABLE KEYS */;
INSERT INTO `sugestores` VALUES (1,0,0,'2016-10-19 18:32:22',1);
/*!40000 ALTER TABLE `sugestores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sugestores_has_estruturas`
--

LOCK TABLES `sugestores_has_estruturas` WRITE;
/*!40000 ALTER TABLE `sugestores_has_estruturas` DISABLE KEYS */;
INSERT INTO `sugestores_has_estruturas` VALUES (2,1,1),(1,1,2);
/*!40000 ALTER TABLE `sugestores_has_estruturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sugestores_has_sugestores`
--

LOCK TABLES `sugestores_has_sugestores` WRITE;
/*!40000 ALTER TABLE `sugestores_has_sugestores` DISABLE KEYS */;
/*!40000 ALTER TABLE `sugestores_has_sugestores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tipos_estrutura`
--

LOCK TABLES `tipos_estrutura` WRITE;
/*!40000 ALTER TABLE `tipos_estrutura` DISABLE KEYS */;
INSERT INTO `tipos_estrutura` VALUES (1,'Select');
/*!40000 ALTER TABLE `tipos_estrutura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-24 22:31:30
