-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: IMS
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `Action`
--

DROP TABLE IF EXISTS `Action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Action` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `keyword` varchar(30) NOT NULL,
  `permission` int DEFAULT NULL,
  UNIQUE KEY `Action_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Action`
--

LOCK TABLES `Action` WRITE;
/*!40000 ALTER TABLE `Action` DISABLE KEYS */;
INSERT INTO `Action` VALUES (1,'顾客信息管理','/CustomerManagement',1),(2,'货物信息管理','/GoodManagement',1),(3,'仓库管理员管理','/PeopleManagement',1),(4,'仓库管理','/StorehouseManagement',2),(5,'供应商管理','/SupplierManagement',1),(6,'顾客信息查询','/CustomerSelect',2),(7,'货物信息查询','/GoodSelect',2),(8,'仓库信息查询','/StorehouseSelect',2),(9,'供应商信息查询','/SupplierSelect',2),(10,'操作记录查询','/ActionRecordSelect',1),(11,'修改密码','/ModifyPassword',2);
/*!40000 ALTER TABLE `Action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Action_Record`
--

DROP TABLE IF EXISTS `Action_Record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Action_Record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `username` varchar(10) NOT NULL,
  `actionName` varchar(20) NOT NULL,
  `time` mediumtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Action_Record_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Action_Record`
--

LOCK TABLES `Action_Record` WRITE;
/*!40000 ALTER TABLE `Action_Record` DISABLE KEYS */;
INSERT INTO `Action_Record` VALUES (2,4,'username','selectAllStorehouse','1649566710197'),(3,4,'username','selectAllStorehouse','1649566837'),(4,4,'username','selectAllRecord','1649571213'),(5,4,'username','selectAllRecord','1649571347387'),(6,5,'common','modifyAdmin','1649575512048'),(7,5,'common','modifyAdmin','1649575528018'),(8,5,'common','modifyAdmin','1649575620866'),(9,5,'common','modifyAdmin','1649575722871'),(10,5,'common','modifyAdmin','1649575875878'),(11,5,'common','modifyAdmin','1649575944797'),(12,5,'common','modifyAdmin','1649576192816'),(13,5,'common','modifyAdmin','1649576399667'),(14,5,'common','modifyAdmin','1649576648626'),(15,5,'common','modifyAdmin','1649576960691'),(16,5,'common','modifyAdmin','1649577630623'),(17,5,'common','modifyAdmin','1649577701089'),(18,5,'common','modifyAdmin','1649577881355'),(19,4,'username','modifyAdmin','1649577955029'),(20,4,'username','addAdmin','1649578259149'),(21,4,'username','addCustomer','1649578308358'),(22,4,'username','modifyCustomer','1649578313239'),(23,4,'username','modifyCustomer','1649578408243'),(24,4,'username','modifyAdmin','1649578442406'),(25,4,'username','modifyAdmin','1649578478810'),(26,5,'common','modifyAdmin','1649578545380'),(27,4,'username','modifyAdmin','1649578687471'),(28,5,'common','modifyAdmin','1649578886572'),(29,5,'common','modifyAdmin','1649579116269'),(30,5,'common','modifyAdmin','1649597189975'),(31,5,'common','selectAllStorehouse','1649643079276'),(32,5,'common','selectAllGood','1649643085011');
/*!40000 ALTER TABLE `Action_Record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `sex` varchar(10) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `address` varchar(15) NOT NULL,
  `storehouseId` int NOT NULL,
  `role` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES (4,'username','password','男','123456','培正',1,'systemAdmin'),(5,'common','password','男','123456','广东',1,'commonAdmin');
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(20) NOT NULL,
  `person` varchar(10) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `email` varchar(15) NOT NULL,
  `address` varchar(20) NOT NULL,
  `pre_order_goods_id` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `customer_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'哔哩哔哩','cherry','123456','123456@qq.com','null','1,2'),(3,'tencent','person','456789','123@abc.com','null','1,2');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Good`
--

DROP TABLE IF EXISTS `Good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Good` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `value` float NOT NULL,
  `Supplier` varchar(20) DEFAULT NULL,
  `Customer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `good_id_uindex` (`id`),
  UNIQUE KEY `good_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Good`
--

LOCK TABLES `Good` WRITE;
/*!40000 ALTER TABLE `Good` DISABLE KEYS */;
INSERT INTO `Good` VALUES (1,'杯子','日用品',5,'章骁聋','cherry'),(2,'耳机','电子产品',50,'雷军','cherry');
/*!40000 ALTER TABLE `Good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StorageRecord`
--

DROP TABLE IF EXISTS `StorageRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StorageRecord` (
  `id` int NOT NULL AUTO_INCREMENT,
  `goodId` int DEFAULT NULL,
  `storehouseId` int DEFAULT NULL,
  `number` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `StorageRecord_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StorageRecord`
--

LOCK TABLES `StorageRecord` WRITE;
/*!40000 ALTER TABLE `StorageRecord` DISABLE KEYS */;
INSERT INTO `StorageRecord` VALUES (3,2,1,10),(8,1,1,50),(9,1,2,10);
/*!40000 ALTER TABLE `StorageRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Storehouse`
--

DROP TABLE IF EXISTS `Storehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Storehouse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(30) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Storehouse_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Storehouse`
--

LOCK TABLES `Storehouse` WRITE;
/*!40000 ALTER TABLE `Storehouse` DISABLE KEYS */;
INSERT INTO `Storehouse` VALUES (1,'广东',1),(2,'广东',1);
/*!40000 ALTER TABLE `Storehouse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Supplier`
--

DROP TABLE IF EXISTS `Supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company` varchar(20) NOT NULL,
  `person` varchar(10) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `email` varchar(15) NOT NULL,
  `address` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Supplier_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Supplier`
--

LOCK TABLES `Supplier` WRITE;
/*!40000 ALTER TABLE `Supplier` DISABLE KEYS */;
INSERT INTO `Supplier` VALUES (1,'腾讯','章骁聋','123456','123456@qq.com','null'),(3,'小米','雷军','123456','123@qq.com','null');
/*!40000 ALTER TABLE `Supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-27 20:30:54
