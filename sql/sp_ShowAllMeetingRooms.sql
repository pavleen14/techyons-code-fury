USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_ShowAllMeetingRooms`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_ShowAllMeetingRooms` ()
BEGIN
		select * from tbl_meetingroom;
END$$

DELIMITER ;

