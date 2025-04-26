-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbpetshop
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `animais`
--

DROP TABLE IF EXISTS `animais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animais` (
  `pkanimal` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `raca` varchar(100) NOT NULL,
  `pkcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`pkanimal`),
  KEY `pkcliente` (`pkcliente`),
  CONSTRAINT `animais_ibfk_1` FOREIGN KEY (`pkcliente`) REFERENCES `clientes` (`pkcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animais`
--

LOCK TABLES `animais` WRITE;
/*!40000 ALTER TABLE `animais` DISABLE KEYS */;
INSERT INTO `animais` VALUES (1,'rex','Cachorro','Pit Bull',NULL),(2,'rex','Cachorro','Pit Bull',NULL);
/*!40000 ALTER TABLE `animais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendimentoprodutos`
--

DROP TABLE IF EXISTS `atendimentoprodutos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atendimentoprodutos` (
  `fkatendimento` int(11) DEFAULT NULL,
  `fkproduto` int(11) DEFAULT NULL,
  KEY `fkatendimento` (`fkatendimento`),
  KEY `fkproduto` (`fkproduto`),
  CONSTRAINT `atendimentoprodutos_ibfk_1` FOREIGN KEY (`fkatendimento`) REFERENCES `atendimentos` (`pkatendimento`),
  CONSTRAINT `atendimentoprodutos_ibfk_2` FOREIGN KEY (`fkproduto`) REFERENCES `produtos` (`pkproduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimentoprodutos`
--

LOCK TABLES `atendimentoprodutos` WRITE;
/*!40000 ALTER TABLE `atendimentoprodutos` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimentoprodutos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendimentos`
--

DROP TABLE IF EXISTS `atendimentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atendimentos` (
  `pkatendimento` int(11) NOT NULL AUTO_INCREMENT,
  `fkcliente` int(11) DEFAULT NULL,
  `fkanimal` int(11) DEFAULT NULL,
  PRIMARY KEY (`pkatendimento`),
  KEY `fkcliente` (`fkcliente`),
  KEY `fkanimal` (`fkanimal`),
  CONSTRAINT `atendimentos_ibfk_1` FOREIGN KEY (`fkcliente`) REFERENCES `clientes` (`pkcliente`),
  CONSTRAINT `atendimentos_ibfk_2` FOREIGN KEY (`fkanimal`) REFERENCES `animais` (`pkanimal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimentos`
--

LOCK TABLES `atendimentos` WRITE;
/*!40000 ALTER TABLE `atendimentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendimentoservicos`
--

DROP TABLE IF EXISTS `atendimentoservicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atendimentoservicos` (
  `fkatendimento` int(11) DEFAULT NULL,
  `fkservico` int(11) DEFAULT NULL,
  KEY `fkatendimento` (`fkatendimento`),
  KEY `fkservico` (`fkservico`),
  CONSTRAINT `atendimentoservicos_ibfk_1` FOREIGN KEY (`fkatendimento`) REFERENCES `atendimentos` (`pkatendimento`),
  CONSTRAINT `atendimentoservicos_ibfk_2` FOREIGN KEY (`fkservico`) REFERENCES `servicos` (`pkservico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimentoservicos`
--

LOCK TABLES `atendimentoservicos` WRITE;
/*!40000 ALTER TABLE `atendimentoservicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendimentoservicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `pkcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `datanasc` date NOT NULL,
  PRIMARY KEY (`pkcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'José','5199999999','2008-02-17');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `pkfuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `funcao` varchar(100) NOT NULL,
  PRIMARY KEY (`pkfuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `pkproduto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `preco` varchar(100) NOT NULL,
  PRIMARY KEY (`pkproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Lenço ','R$ 20 '),(3,'Pedrinha Adesiva ','R$ 5');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicos`
--

DROP TABLE IF EXISTS `servicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicos` (
  `pkservico` int(11) NOT NULL AUTO_INCREMENT,
  `nomeservico` varchar(100) NOT NULL,
  `preco` varchar(50) NOT NULL,
  `tempo` varchar(30) NOT NULL,
  PRIMARY KEY (`pkservico`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicos`
--

LOCK TABLES `servicos` WRITE;
/*!40000 ALTER TABLE `servicos` DISABLE KEYS */;
INSERT INTO `servicos` VALUES (5,'Banho Completo ','R$ 100','1 Hora'),(6,'Somente Tosa','R$ 70','40 Minutos'),(7,'Banho a Seco ','R$ 120','1 Hora  e 20 Minutos');
/*!40000 ALTER TABLE `servicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `pkusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `datanasc` date DEFAULT NULL,
  PRIMARY KEY (`pkusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'matheus','matheus@gmail.com','9048ead9080d9b27d6b2b6ed363cbf8cce795f7f','0000-00-00'),(2,'matheus farias ','matheusfarias@gmail.com','7c222fb2927d828af22f592134e8932480637c0d','2008-02-17');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-24 22:19:44
