USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_ShowAllMeetingRooms`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_ShowAllMeetingRooms` ()
BEGIN
			SELECT*  FROM tbl_meetingroom;
END$$

DELIMITER ;

