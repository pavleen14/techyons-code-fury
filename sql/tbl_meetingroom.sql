DROP TABLE IF EXISTS `tbl_meetingroom`;
CREATE TABLE `tbl_meetingroom` (
  `MeetingRoomId` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `SeatingCapacity` int NOT NULL,
  `Rating` float NOT NULL DEFAULT '0',
  `PerHourCost` decimal(4,2) DEFAULT '0.00',
  `NumberOfFeedbacks` int NOT NULL DEFAULT '0',
  `NumberOfMeetings` int DEFAULT '0',
  PRIMARY KEY (`MeetingRoomId`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) ;
ALTER TABLE `tbl_meetingroom` 
CHANGE COLUMN `MeetingRoomId` `MeetingRoomId` INT NOT NULL ,
CHANGE COLUMN `Name` `Name` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `SeatingCapacity` `SeatingCapacity` INT NOT NULL ,
CHANGE COLUMN `Rating` `Rating` FLOAT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `PerHourCost` `PerHourCost` DECIMAL(4,2) NULL DEFAULT '0' ,
CHANGE COLUMN `NumberOfFeedbacks` `NumberOfFeedbacks` INT NOT NULL DEFAULT '0' ,
CHANGE COLUMN `NumberOfMeetings` `NumberOfMeetings` INT NULL DEFAULT '0' ;
