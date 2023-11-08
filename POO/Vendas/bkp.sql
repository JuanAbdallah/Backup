-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: localhost    Database: vendas
-- ------------------------------------------------------
-- Server version	8.0.31-0ubuntu0.22.04.1

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
-- Table structure for table `ItemVenda`
--

DROP TABLE IF EXISTS `ItemVenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ItemVenda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_venda` int NOT NULL,
  `id_produto` int NOT NULL,
  `quantidade` int NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ItemVenda_FK` (`id_venda`),
  KEY `ItemVenda_FK_1` (`id_produto`),
  CONSTRAINT `ItemVenda_FK` FOREIGN KEY (`id_venda`) REFERENCES `Venda` (`id`),
  CONSTRAINT `ItemVenda_FK_1` FOREIGN KEY (`id_produto`) REFERENCES `Produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ItemVenda`
--

LOCK TABLES `ItemVenda` WRITE;
/*!40000 ALTER TABLE `ItemVenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `ItemVenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Produto` (
  `nome` varchar(50) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `preco` double NOT NULL,
  `peso_embalagem` varchar(100) DEFAULT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Produto_FK` (`id_categoria`),
  CONSTRAINT `Produto_FK` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Venda`
--

DROP TABLE IF EXISTS `Venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Venda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_venda` datetime NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Venda_FK` (`id_cliente`),
  CONSTRAINT `Venda_FK` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Venda`
--

LOCK TABLES `Venda` WRITE;
/*!40000 ALTER TABLE `Venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `Venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `tem_isencao` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `email` varchar(80) NOT NULL,
  `login` varchar(16) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `data_nascimento` datetime DEFAULT NULL,
  `perfil` enum('CLIENTE','ADMIN','CONSULTA') NOT NULL DEFAULT 'CLIENTE',
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UN` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'vendas'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-30 20:14:49
