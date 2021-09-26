USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_CheckMeetingRoomIfExists`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckMeetingRoomIfExists` (IN NameInput varchar(50))
BEGIN
	SELECT * FROM tbl_meetingroom WHERE Name = NameInput;
END$$

DELIMITER ;

