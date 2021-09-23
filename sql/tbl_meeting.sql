DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `tbl_meeting` (
  `MeetingId` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(45) NOT NULL,
  `OrganizedBy` int DEFAULT NULL,
  `StartTme` datetime NOT NULL,
  `EndTime` datetime DEFAULT NULL,
  `TypeOfMeeting` enum('CLASSROOM_TRAINING','ONLINE_TRAINING','CONFERENCE_CALL','BUSINESS') DEFAULT NULL,
  `MeetingRoomId` int DEFAULT NULL,
  `BookedBy` int DEFAULT NULL,
  PRIMARY KEY (`MeetingId`),
  UNIQUE KEY `Title_UNIQUE` (`Title`),
  KEY `MeetingRoomId_idx` (`MeetingRoomId`),
  KEY `BookedBy_idx` (`BookedBy`),
  KEY `OrganizedBy_idx` (`OrganizedBy`),
  CONSTRAINT `BookedBy` FOREIGN KEY (`BookedBy`) REFERENCES `tbl_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OrganizedBy` FOREIGN KEY (`OrganizedBy`) REFERENCES `tbl_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `RoomId` FOREIGN KEY (`MeetingRoomId`) REFERENCES `tbl_meetingroom` (`MeetingRoomId`) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE `tbl_meeting` 
CHANGE COLUMN `MeetingId` `MeetingId` INT NOT NULL ,
CHANGE COLUMN `Title` `Title` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `OrganizedBy` `OrganizedBy` INT NULL DEFAULT NULL ,
CHANGE COLUMN `StartTme` `StartTme` DATETIME NOT NULL ,
CHANGE COLUMN `EndTime` `EndTime` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `TypeOfMeeting` `TypeOfMeeting` ENUM('CLASSROOM_TRAINING', 'ONLINE_TRAINING', 'CONFERENCE_CALL', 'BUSINESS') NULL DEFAULT NULL ,
CHANGE COLUMN `MeetingRoomId` `MeetingRoomId` INT NULL DEFAULT NULL ,
CHANGE COLUMN `BookedBy` `BookedBy` INT NULL DEFAULT NULL ;
