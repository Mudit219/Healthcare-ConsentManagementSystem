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
  `meta_id` varchar(200) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `specialization` varchar(100) DEFAULT NULL,
  `doctor_license` varchar(45) NOT NULL,
  `doctor_image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1290,'rajev12@yahoo.co.in','Male','Rajeev','8843922129','General Physician','#DC2312','https://www.google.com/search?q=doctor+images&hl=en&source=lnms&tbm=isch&sa=X&ved=2ahUKEwignIGR3v32AhWQGqYKHXTOAigQ_AUoAXoECAEQAw&biw=1396&bih=656&dpr=1.38#imgrc=Q8k6nVWxU9t-PM'),(5663,'arun@yahoo.com','Male','Arun','5485932012','General Physician','#DC2121','https://www.google.com/search?q=doctor+images&hl=en&source=lnms&tbm=isch&sa=X&ved=2ahUKEwignIGR3v32AhWQGqYKHXTOAigQ_AUoAXoECAEQAw&biw=1396&bih=656&dpr=1.38#imgrc=2KU6-hSwFK_jQM'),(5892,'ram231@gmail.com','Male','Ramesh','9002100210','General Physician','#DC1243','https://www.google.com/search?q=doctor+images&hl=en&source=lnms&tbm=isch&sa=X&ved=2ahUKEwignIGR3v32AhWQGqYKHXTOAigQ_AUoAXoECAEQAw&biw=1396&bih=656&dpr=1.38#imgrc=aueMOhHXoexX5M'),(6554,'bharathy@gmail.com','Female','Bharathy','6784392112','General Physician','#DC3654','https://www.google.com/search?q=doctor+images&hl=en&source=lnms&tbm=isch&sa=X&ved=2ahUKEwignIGR3v32AhWQGqYKHXTOAigQ_AUoAXoECAEQAw&biw=1396&bih=656&dpr=1.38#imgrc=XkYto98OjeMgCM'),(9669,'lok@gmail.com','Male','Lokesh','4354352222','General Physician','#DC3321','https://www.google.com/search?q=doctor+images&hl=en&source=lnms&tbm=isch&sa=X&ved=2ahUKEwignIGR3v32AhWQGqYKHXTOAigQ_AUoAXoECAEQAw&biw=1396&bih=656&dpr=1.38#imgrc=ifI29uxd7Hi-IM');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `meta_id` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `patient_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `patient_image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1234,'mudit@gmail.com','Male','Mudit','8574932920','https://www.google.com/search?q=people+images&tbm=isch&ved=2ahUKEwi9yY3x3v32AhX9ZWwGHQ-FBlwQ2-cCegQIABAA&oq=people+images&gs_lcp=CgNpbWcQAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6BAgAEEM6BwgAELEDEEM6CwgAEIAEELEDEIMBUPoJWIYWYK8XaABwAHgAgAGkAYgBiA-SAQQwLjE0mAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=yKNMYr3FI_3LseMPj4qa4AU&bih=656&biw=1396&hl=en#imgrc=9J4U3ls-3Zhn5M'),(3421,'arpita@yahoo.com','Female','Arpitha','6429482291','https://www.google.com/search?q=people+images&tbm=isch&ved=2ahUKEwi9yY3x3v32AhX9ZWwGHQ-FBlwQ2-cCegQIABAA&oq=people+images&gs_lcp=CgNpbWcQAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6BAgAEEM6BwgAELEDEEM6CwgAEIAEELEDEIMBUPoJWIYWYK8XaABwAHgAgAGkAYgBiA-SAQQwLjE0mAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=yKNMYr3FI_3LseMPj4qa4AU&bih=656&biw=1396&hl=en#imgrc=ZLmcHB3RUei1nM'),(5422,'saxsy@gmail.com','Male','Saksham','9545323431',NULL),(8231,'mrinal@yahoo.co.in','Male','Mrinal','8493238493','https://www.google.com/search?q=people+images&tbm=isch&ved=2ahUKEwi9yY3x3v32AhX9ZWwGHQ-FBlwQ2-cCegQIABAA&oq=people+images&gs_lcp=CgNpbWcQAzIICAAQgAQQsQMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQ6BAgAEEM6BwgAELEDEEM6CwgAEIAEELEDEIMBUPoJWIYWYK8XaABwAHgAgAGkAYgBiA-SAQQwLjE0mAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=yKNMYr3FI_3LseMPj4qa4AU&bih=656&biw=1396&hl=en#imgrc=W8x6GntEqn7x7M&imgdii=3wBoAhDKKpyMVM'),(8989,'jan@gmail.com','Female','Janvi','7433232398',NULL);
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
  `doctor_license` varchar(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`ehr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ehealth_records`
--

LOCK TABLES `ehealth_records` WRITE;
/*!40000 ALTER TABLE `ehealth_records` DISABLE KEYS */;
INSERT INTO `ehealth_records` VALUES (1,'Narayana Hospital','Mudit','Arun','Nexium','Ulcer','8574932920','#DC2121','2021-11-02'),(2,'Kavery Hospital','Mrinal','Ramesh','Crestor','Cholestrol','8493238493','#DC1243','2021-10-12'),(3,'Sacred Oak Hospital','Saksham','Rajeev','Amoxicillin','Bacterial infection','9545323431','#DC2312','2021-01-24'),(4,'Sacred Oak Hospital','Aman','Rajeev','Lisinopril','High Blood pressure','9850384322','#DC2312','2020-11-02'),(5,'Fortis Hospital','Asilata','Lokesh','Nexium','Gastric Trouble','6837921994','#DC3321','2021-05-02'),(6,'Kavery Hospital','Tarun','Ramesh','Amoxicillin','Pneumonia','6568839021','#DC1243','2020-11-02'),(7,'Narayana Hospital','Nachiappan','Arun','Amoxicillin','Dental abscesses','9658492942','#DC2121','2021-10-02'),(8,'Fortis Hospital','Parithi','Lokesh','Crestor','Cholestrol','8839298432','#DC3321','2021-01-07'),(9,'Apollo Hospital','Vikram','Renjith','Dolo','Headache','7439292994','#DC7865','2021-11-21'),(10,'Narayana Hospital','Anvith','Bharathy','Dolo','Fever','8839923534','#DC3654','2021-12-22'),(11,'Fortis Hospital','Pankaj','Lokesh','Metformin','Diabetics','7388532932','#DC3321','2020-05-02'),(12,'Apollo Hospital','Omkar','Renjith','Robafen','Common Cold','6648292221','#DC7865','2021-06-02'),(13,'Sacred Oak Hospital','Saad','Rajeev','Dolo','Headache','8765938432','#DC2312','2020-06-08'),(14,'Kavery Hospital','Sriram','Ramesh','Robafen','Bronchitis','9992332999','#DC1243','2022-01-02'),(15,'Narayana Hospital','Khaveesh','Bharathy','Nexium','Heartburn','8989892893','#DC3654','2021-04-14'),(16,'Fortis Hospital','Shashank','Rahul','Nexium','Ulcer','9888777721','#DC6521','2020-11-19'),(17,'Fortis Hospital','Sama','Rahul','Metformin','Diabetics','7867846842','#DC6521','2021-12-22'),(18,'Kavery Hospital','Janvi','Ramesh','Dolo','Body Pain','7433232398','#DC1243','2020-09-07'),(19,'Apollo Hospital','Nikitha','Renjith','Nexium','Stomach Problem','7774396842','#DC7865','2021-09-09'),(20,'Apollo Hospital','Arpitha','Renjith','Dolo','Fever','6429482291','#DC7865','2022-03-28');
/*!40000 ALTER TABLE `ehealth_records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-06  2:02:15
