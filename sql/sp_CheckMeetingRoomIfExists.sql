USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_CheckMeetingRoomIfExists`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckMeetingRoomIfExists` (IN NameInput varchar(50))
BEGIN
	select * from tbl_meetingroom where MeetingRoomId = NameInput;
END$$

DELIMITER ;

