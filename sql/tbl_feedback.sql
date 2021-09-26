DROP TABLE IF EXISTS `tbl_feedback`;
CREATE TABLE `tbl_feedback` (
  `FeedbackId` int NOT NULL,
  `Rating` int DEFAULT NULL,
  `Comments` varchar(45) DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  `MeetingRoomId` int DEFAULT NULL,
  PRIMARY KEY (`FeedbackId`),
  KEY `UserId_idx` (`UserId`),
  KEY `MeetingRoomId_idx` (`MeetingRoomId`),
  CONSTRAINT `MeetingRoom_ID` FOREIGN KEY (`MeetingRoomId`) REFERENCES `tbl_meetingroom` (`MeetingRoomId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `User_ID` FOREIGN KEY (`UserId`) REFERENCES `tbl_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
);
ALTER TABLE `tbl_feedback` 
CHANGE COLUMN `FeedbackId` `FeedbackId` INT NOT NULL ,
CHANGE COLUMN `Rating` `Rating` INT NULL DEFAULT NULL ,
CHANGE COLUMN `Comments` `Comments` VARCHAR(45) NULL DEFAULT NULL ;
