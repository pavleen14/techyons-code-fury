USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_InsertIntoMeeting`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertIntoMeeting` ( IN TitleInput varchar(45),IN OrganizedByInput int, IN StartTimeInput DATETIME,IN EndTimeInput DATETIME,IN TypeOfMeetingInput varchar(20),IN RoomIdInput INT)
BEGIN
	INSERT INTO `meeting_room_booking_db`.`tbl_meeting`
(`MeetingId`,
`Title`,
`OrganizedBy`,
`StartTme`,
`EndTime`,
`TypeOfMeeting`,
`MeetingRoomId`,
`BookedBy`)
VALUES
(ceiling(RAND()*1000000),
TitleInput,
OrganizedByInput,
StartTimeInput,
EndTimeInput,
TypeOfMeetingInput,
RoomIdInput,
OrganizedByInput);

UPDATE tbl_users SET credits = credits - (select  ceil((TIMESTAMPDIFF(SECOND, StartTimeInput, EndTimeInput))/3600)*a.PerHourCost as meeting_cost
from 
 tbl_meetingroom  a
where a.MeetingRoomId = RoomIdInput) WHERE ID = OrganizedByInput; 


SELECT MeetingId
FROM tbl_meeting
WHERE MeetingRoomId = RoomIdInput
AND Starttme = StartTimeInput;

END$$

DELIMITER ;
