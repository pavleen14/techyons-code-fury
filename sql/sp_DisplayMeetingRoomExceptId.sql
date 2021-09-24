USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_DisplayMeetingRoomExceptId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_DisplayMeetingRoomExceptId` ()
BEGIN
	select Name, SeatingCapacity, Rating,PerHourCost,NumberOfFeedbacks from tbl_meetingroom;
END$$

DELIMITER ;


