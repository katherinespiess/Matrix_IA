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
-- Dumping data for table `datas`
--

LOCK TABLES `datas` WRITE;
/*!40000 ALTER TABLE `datas` DISABLE KEYS */;
/*!40000 ALTER TABLE `datas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estruturas`
--

LOCK TABLES `estruturas` WRITE;
/*!40000 ALTER TABLE `estruturas` DISABLE KEYS */;
INSERT INTO `estruturas` VALUES (1,1,'Select \'A\' from dual'),(2,1,'select ds from palavras where id in \n	(select fhp.id_p from frases_has_palavras fhp, frases_has_palavras fhp2     \n		where fhp.id_f = fhp2.id_f\n		and fhp2.id_p in (select id from palavras where ds like concat(\'%\', :lastWord, \'%\'))\n        and fhp.id_p not in (select id from palavras where ds like concat(\'%\', :lastWord, \'%\')))');
/*!40000 ALTER TABLE `estruturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `frases`
--

LOCK TABLES `frases` WRITE;
/*!40000 ALTER TABLE `frases` DISABLE KEYS */;
INSERT INTO `frases` VALUES (1,3),(2,1);
/*!40000 ALTER TABLE `frases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `frases_has_palavras`
--

LOCK TABLES `frases_has_palavras` WRITE;
/*!40000 ALTER TABLE `frases_has_palavras` DISABLE KEYS */;
INSERT INTO `frases_has_palavras` VALUES (3,2,2),(1,1,3),(2,1,4),(4,2,14);
/*!40000 ALTER TABLE `frases_has_palavras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `palavras`
--

LOCK TABLES `palavras` WRITE;
/*!40000 ALTER TABLE `palavras` DISABLE KEYS */;
INSERT INTO `palavras` VALUES (1,'A',1),(2,'Alô',1),(3,'Olá',1),(4,'Mundo!',13),(5,'a',1),(6,'alo',1),(7,'olá',1),(8,'ola',1),(9,'alô',1),(10,'o',1),(11,'O',1),(12,'e',1),(13,'E',1),(14,'mundo',1),(15,'Mundo',1);
/*!40000 ALTER TABLE `palavras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pontuacoes`
--

LOCK TABLES `pontuacoes` WRITE;
/*!40000 ALTER TABLE `pontuacoes` DISABLE KEYS */;
INSERT INTO `pontuacoes` VALUES (1,''),(2,'.'),(3,','),(4,';'),(5,'-'),(6,':'),(7,'('),(8,')'),(9,'['),(10,']'),(11,'{'),(12,'}'),(13,'!'),(14,'?'),(15,'!!!'),(16,'???'),(17,'!?!'),(18,'...');
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
-- Dumping data for table `textos`
--

LOCK TABLES `textos` WRITE;
/*!40000 ALTER TABLE `textos` DISABLE KEYS */;
/*!40000 ALTER TABLE `textos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `textos_has_datas`
--

LOCK TABLES `textos_has_datas` WRITE;
/*!40000 ALTER TABLE `textos_has_datas` DISABLE KEYS */;
/*!40000 ALTER TABLE `textos_has_datas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `textos_has_frases`
--

LOCK TABLES `textos_has_frases` WRITE;
/*!40000 ALTER TABLE `textos_has_frases` DISABLE KEYS */;
/*!40000 ALTER TABLE `textos_has_frases` ENABLE KEYS */;
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

-- Dump completed on 2016-10-25 10:23:54
