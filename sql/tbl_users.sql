DROP TABLE IF EXISTS `tbl_users`;
CREATE TABLE `tbl_users` (
  `ID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Credits` int NOT NULL,
  `Role` enum('ADMIN','MANAGER','MEMBER') DEFAULT NULL,
  `Password` varchar(32) NOT NULL,
  `LastLogin` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
);
ALTER TABLE `tbl_users` 
CHANGE COLUMN `ID` `ID` INT NOT NULL ,
CHANGE COLUMN `Name` `Name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `Email` `Email` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `Phone` `Phone` VARCHAR(13) NOT NULL ,
CHANGE COLUMN `Credits` `Credits` INT NOT NULL ,
CHANGE COLUMN `Role` `Role` ENUM('ADMIN', 'MANAGER', 'MEMBER') NULL DEFAULT NULL ,
CHANGE COLUMN `Password` `Password` VARCHAR(32) NOT NULL ,
CHANGE COLUMN `LastLogin` `LastLogin` TIMESTAMP(6) NULL DEFAULT NULL ;
