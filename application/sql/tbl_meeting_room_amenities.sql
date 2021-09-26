DROP TABLE IF EXISTS `tbl_meeting_room_amenities`;
CREATE TABLE `tbl_meeting_room_amenities` (
  `AmenityId` int NOT NULL,
  `MeetingRoomId` int NOT NULL,
  PRIMARY KEY (`AmenityId`,`MeetingRoomId`),
  KEY `MeetingRoomId_idx` (`MeetingRoomId`),
  CONSTRAINT `AmenityId` FOREIGN KEY (`AmenityId`) REFERENCES `tbl_amenities` (`AmenityId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MeetingRoomConstraint` FOREIGN KEY (`MeetingRoomId`) REFERENCES `tbl_meetingroom` (`MeetingRoomId`) ON DELETE CASCADE ON UPDATE CASCADE
);