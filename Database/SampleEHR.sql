-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital_database
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `meta_id` int NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1290,'rajev12@yahoo.co.in','Male','Rajeev','8843922129'),(5663,'arun@yahoo.com','Male','Arun','5485932012'),(5892,'ram231@gmail.com','Male','Ramesh','9002100210'),(6554,'bharathy@gmail.com','Female','Bharathy','6784392112'),(9669,'lok@gmail.com','Male','Lokesh','4354352222');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `meta_id` int NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `patient_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1234,'mudit@gmail.com','Male','Mudit','8574932920'),(3421,'arpita@yahoo.com','Female','Arpitha','6429482291'),(5422,'saxsy@gmail.com','Male','Saksham','9545323431'),(8231,'mrinal@yahoo.co.in','Male','Mrinal','8493238493'),(8989,'jan@gmail.com','Female','Janvi','7433232398');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `records`
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
  `patient_phone` varchar(10) NOT NULL,
  PRIMARY KEY (`ehr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `records`
--

LOCK TABLES `ehealth_records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `ehealth_records` VALUES (1,'Narayana Hospital','Mudit','Arun','Nexium','Ulcer','8574932920'),(2,'Kavery Hospital','Mrinal','Ramesh','Crestor','Cholestrol','8493238493'),(3,'Sacred Oak Hospital','Saksham','Rajeev','Amoxicillin','Bacterial infection','9545323431'),(4,'Sacred Oak Hospital','Aman','Rajeev','Lisinopril','High Blood pressure','9850384322'),(5,'Fortis Hospital','Asilata','Lokesh','Nexium','Gastric Trouble','6837921994'),(6,'Kavery Hospital','Tarun','Ramesh','Amoxicillin','Pneumonia','6568839021'),(7,'Narayana Hospital','Nachiappan','Arun','Amoxicillin','Dental abscesses','9658492942'),(8,'Fortis Hospital','Mudit','Lokesh','Crestor','Cholestrol','8574932920'),(9,'Apollo Hospital','Saksham','Renjith','Dolo','Headache','9545323431'),(10,'Narayana Hospital','Saksham','Bharathy','Dolo','Fever','9545323431'),(11,'Fortis Hospital','Pankaj','Lokesh','Metformin','Diabetics','7388532932'),(12,'Apollo Hospital','Omkar','Renjith','Robafen','Common Cold','6648292221'),(13,'Sacred Oak Hospital','Saad','Rajeev','Dolo','Headache','8765938432'),(14,'Kavery Hospital','Sriram','Ramesh','Robafen','Bronchitis','9992332999'),(15,'Narayana Hospital','Mudit','Bharathy','Nexium','Heartburn','8574932920'),(16,'Fortis Hospital','Mudit','Rahul','Nexium','Ulcer','8574932920'),(17,'Fortis Hospital','Saksham','Rahul','Metformin','Diabetics','9545323431'),(18,'Kavery Hospital','Janvi','Ramesh','Dolo','Body Pain','7433232398'),(19,'Apollo Hospital','Mudit','Renjith','Nexium','Stomach Problem','8574932920'),(20,'Apollo Hospital','Arpitha','Renjith','Dolo','Fever','6429482291');
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-04 23:34:59
