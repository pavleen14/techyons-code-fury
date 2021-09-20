CREATE TABLE `users` (
  `ID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Phone` varchar(13) NOT NULL,
  `Credits` int NOT NULL,
  `Role` enum('Admin','Manager','Member') DEFAULT NULL,
  `Password` varchar(45) NOT NULL,
  `LastLogin` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
)

CREATE TABLE `meetingroom` (
  `MeetingRoomId` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `SeatingCapacity` int NOT NULL,
  `Rating` float NOT NULL,
  `PerHourCost` decimal(4,2) DEFAULT NULL,
  `NumberOfFeedbacks` int NOT NULL,
  PRIMARY KEY (`MeetingRoomId`),
  UNIQUE KEY `Name_UNIQUE` (`Name`)
) 

CREATE TABLE `meeting` (
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
  CONSTRAINT `BookedBy` FOREIGN KEY (`BookedBy`) REFERENCES `users` (`ID`),
  CONSTRAINT `OrganizedBy` FOREIGN KEY (`OrganizedBy`) REFERENCES `users` (`ID`),
  CONSTRAINT `RoomId` FOREIGN KEY (`MeetingRoomId`) REFERENCES `meetingroom` (`MeetingRoomId`) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE `projectdatabase`.`feedback` (
  `FeedbackId` INT NOT NULL,
  `Rating` INT NULL,
  `Comments` VARCHAR(45) NULL,
  `UserId` INT NULL,
  `MeetingRoomId` INT NULL,
  PRIMARY KEY (`FeedbackId`),
  INDEX `UserId_idx` (`UserId` ASC) VISIBLE,
  INDEX `MeetingRoomId_idx` (`MeetingRoomId` ASC) VISIBLE,
  CONSTRAINT `UserId`
    FOREIGN KEY (`UserId`)
    REFERENCES `projectdatabase`.`users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MeetingRoomId`
    FOREIGN KEY (`MeetingRoomId`)
    REFERENCES `projectdatabase`.`meetingroom` (`MeetingRoomId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    CREATE TABLE `meeting_room_amenities` (
  `AmenityId` int NOT NULL,
  `MeetingRoomId` int NOT NULL,
  PRIMARY KEY (`AmenityId`,`MeetingRoomId`),
  KEY `MeetingRoomId_idx` (`MeetingRoomId`),
  CONSTRAINT `AmenityId` FOREIGN KEY (`AmenityId`) REFERENCES `amenities` (`AmenityId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MeetingRoomId` FOREIGN KEY (`MeetingRoomId`) REFERENCES `meetingroom` (`MeetingRoomId`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `attendee` (
  `MeetingId` int DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  KEY `UserId_idx` (`UserId`),
  KEY `MeetingId_idx` (`MeetingId`),
  CONSTRAINT `MeetingId` FOREIGN KEY (`MeetingId`) REFERENCES `meeting` (`MeetingId`),
  CONSTRAINT `UserID` FOREIGN KEY (`UserId`) REFERENCES `users` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `amenities` (
  `AmenityId` int NOT NULL,
  `AmenityName` varchar(45) DEFAULT NULL,
  `AmenityCost` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`AmenityId`)
);


delimiter //
create trigger feedback_ins 
after insert 
on feedback
for each row
update meetingroom set rating=(select avg(Rating) from Feedback where MeetingRoomId= NEW.MeetingRoomId), 
NumberOfFeedbacks= coalesce(NumberOfFeedbacks,0)+1 
where MeetingRoomId= NEW.MeetingRoomId;//
delimiter ;


delimiter //
create trigger Meeting_emenities_ins 
after insert 
on meeting_room_amenities
for each row
update MeetingRoom set perHourCost=(select sum(AmenityCost) from amenities a join (select * from meeting_room_amenities
 where MeetingRoomId=NEW.MeetingRoomId)x  on a.amenityId= x.amenityId)+
case when seatingcapacity<=5 then 0 
when seatingcapacity>5 and seatingcapacity<=10 then 10
else 20
end
where MeetingRoomId= NEW.MeetingRoomId;//
delimiter ;