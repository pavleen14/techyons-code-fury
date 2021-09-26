USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_SelectMeetingRoomIdFromMeetingRoomByName`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_SelectMeetingRoomIdFromMeetingRoomByName` (IN NameInput varchar(30))
BEGIN
SELECT MeetingRoomId FROM tbl_meetingroom WHERE Name=NameInput;
END$$

DELIMITER ;