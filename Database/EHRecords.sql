-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital_database
-- ------------------------------------------------------
-- Server version	8.0.21
use consentmanagement;
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
-- Table structure for table `ehealth_records`
--

DROP TABLE IF EXISTS `ehealth_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ehealth_records` (
  `ehr_id` int NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `doctor_name` varchar(100) NOT NULL,
  `prescription` varchar(200) DEFAULT NULL,
  `diagnosis` varchar(200) DEFAULT NULL,
  `patient_phone` int NOT NULL,
  PRIMARY KEY (`ehr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ehealth_records`
--


/*!40000 ALTER TABLE `ehealth_records` DISABLE KEYS */;
INSERT INTO `ehealth_records` VALUES (1,'B','AB','BB','Nexium','Ulcer',0),(2,'A','AC','BC','Crestor','Cholestrol',1),(3,'C','AD','BD','Amoxicillin','Bacterial infection',2),(4,'C','AE','BE','Lisinopril','High Blood pressure',3),(5,'D','AF','BB','Nexium','Gastric Trouble',4),(6,'B','AG','BD','Amoxicillin','Pneumonia',5),(7,'A','AH','BC','Amoxicillin','Dental abscesses',6),(8,'D','AI','BB','Crestor','Cholestrol',7),(9,'E','AJ','BA','Dolo','Headache',8),(10,'B','AK','BA','Dolo','Fever',9),(11,'C','AL','BE','Metformin','Diabetics',10),(12,'C','AM','BD','Robafen','Common Cold',11),(13,'A','AN','BA','Dolo','Headache',12),(14,'D','AO','BB','Robafen','Bronchitis',13),(15,'E','AP','BB','Nexium','Heartburn',14),(16,'A','AQ','BA','Nexium','Ulcer',15),(17,'A','AR','BE','Metformin','Diabetics',16),(18,'C','AS','BE','Dolo','Body Pain',17),(19,'B','AT','BD','Nexium','Stomach Problem',18),(20,'A','AA','BA','Dolo','Fever',19);
/*!40000 ALTER TABLE `ehealth_records` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-31 14:43:40
