--
-- Table structure for table `doctor`
--
Use consentmanagement;

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `meta_id` varchar(200) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `doctor_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` VALUES (1290,'rajev12@yahoo.co.in','Male','Rajeev','8843922129'),(5663,'arun@yahoo.com','Male','Arun','5485932012'),(5892,'ram231@gmail.com','Male','Ramesh','9002100210'),(6554,'bharathy@gmail.com','Female','Bharathy','6784392112'),(9669,'lok@gmail.com','Male','Lokesh','4354352222');

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `meta_id` varchar(200) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `patient_name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`meta_id`)
);

--
-- Dumping data for table `patient`
--
INSERT INTO `patient` VALUES (1234,'mudit@gmail.com','Male','Mudit','8574932920'),(3421,'arpita@yahoo.com','Female','Arpitha','6429482291'),(5422,'saxsy@gmail.com','Male','Saksham','9545323431'),(8231,'mrinal@yahoo.co.in','Male','Mrinal','8493238493'),(8989,'jan@gmail.com','Female','Janvi','7433232398');
--
-- Table structure for table `records`
--

CREATE DATABASE narayana_hospital_db;
USE narayana_hospital_db;

DROP TABLE IF EXISTS `ehealth_records`;
CREATE TABLE `ehealth_records` (
  `ehr_id` int NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `doctor_name` varchar(100) NOT NULL,
  `prescription` varchar(200) DEFAULT NULL,
  `diagnosis` varchar(200) DEFAULT NULL,
  `patient_phone` varchar(10) NOT NULL,
  PRIMARY KEY (`ehr_id`)
);

--
-- Dumping data for table `records`
--

INSERT INTO `ehealth_records` VALUES (1,'Narayana Hospital','Mudit','Arun','Nexium','Ulcer','8574932920'),(2,'Narayana Hospital','Nachiappan','Arun','Amoxicillin','Dental abscesses','9658492942'),(3,'Narayana Hospital','Saksham','Bharathy','Dolo','Fever','9545323431'),(4,'Narayana Hospital','Mudit','Bharathy','Nexium','Heartburn','8574932920');

CREATE DATABASE fortis_hospital_db;
USE fortis_hospital_db;

DROP TABLE IF EXISTS `ehealth_records`;
CREATE TABLE `ehealth_records` (
  `ehr_id` int NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `doctor_name` varchar(100) NOT NULL,
  `prescription` varchar(200) DEFAULT NULL,
  `diagnosis` varchar(200) DEFAULT NULL,
  `patient_phone` varchar(10) NOT NULL,
  PRIMARY KEY (`ehr_id`)
);

--
-- Dumping data for table `records`
--

INSERT INTO `ehealth_records` VALUES (5,'Fortis Hospital','Mudit','Rahul','Nexium','Ulcer','8574932920'),(6,'Fortis Hospital','Saksham','Rahul','Metformin','Diabetics','9545323431'),(7,'Fortis Hospital','Mudit','Lokesh','Crestor','Cholestrol','8574932920'),(8,'Fortis Hospital','Asilata','Lokesh','Nexium','Gastric Trouble','6837921994'),(9,'Fortis Hospital','Pankaj','Lokesh','Metformin','Diabetics','7388532932');


CREATE DATABASE kavery_hospital_db;
USE kavery_hospital_db;

DROP TABLE IF EXISTS `ehealth_records`;
CREATE TABLE `ehealth_records` (
  `ehr_id` int NOT NULL,
  `hospital_name` varchar(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `doctor_name` varchar(100) NOT NULL,
  `prescription` varchar(200) DEFAULT NULL,
  `diagnosis` varchar(200) DEFAULT NULL,
  `patient_phone` varchar(10) NOT NULL,
  PRIMARY KEY (`ehr_id`)
);

--
-- Dumping data for table `records`
--

INSERT INTO `ehealth_records` VALUES (10,'Kavery Hospital','Janvi','Ramesh','Dolo','Body Pain','7433232398'),(11,'Kavery Hospital','Mrinal','Ramesh','Crestor','Cholestrol','8493238493'),(12,'Apollo Hospital','Omkar','Renjith','Robafen','Common Cold','6648292221'),(13,'Kavery Hospital','Sriram','Ramesh','Robafen','Bronchitis','9992332999');




