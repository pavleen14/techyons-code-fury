DROP TABLE IF EXISTS `tbl_attendee`;
CREATE TABLE `tbl_attendee` (
  `MeetingId` int DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  KEY `UserId_idx` (`UserId`),
  KEY `MeetingId_idx` (`MeetingId`),
  CONSTRAINT `MeetingId` FOREIGN KEY (`MeetingId`) REFERENCES `tbl_meeting` (`MeetingId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UserID` FOREIGN KEY (`UserId`) REFERENCES `tbl_users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
);