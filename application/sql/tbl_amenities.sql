DROP TABLE IF EXISTS `tbl_amenities`;
CREATE TABLE `tbl_amenities` (
  `AmenityId` int NOT NULL,
  `AmenityName` varchar(45) DEFAULT NULL,
  `AmenityCost` float DEFAULT NULL,
  PRIMARY KEY (`AmenityId`)
) ;

ALTER TABLE `tbl_amenities` 
CHANGE COLUMN `AmenityId` `AmenityId` INT NOT NULL ,
CHANGE COLUMN `AmenityName` `AmenityName` VARCHAR(45) NULL DEFAULT NULL ,
CHANGE COLUMN `AmenityCost` `AmenityCost` FLOAT NULL DEFAULT NULL ;
