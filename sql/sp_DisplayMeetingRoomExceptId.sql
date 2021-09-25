USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_DisplayMeetingRoomExceptId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_DisplayMeetingRoomExceptId` ()
BEGIN
	SELECT Name, SeatingCapacity, Rating,PerHourCost,NumberOfFeedbacks FROM tbl_meetingroom;
END$$

DELIMITER ;


