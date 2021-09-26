USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_UpdateMeetingRoomById`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_UpdateMeetingRoomById` (IN NameInput varchar(20), IN SeatingCapacityInput INT, IN MeetingRoomIdInput INT)
BEGIN
UPDATE tbl_meetingroom SET Name = NameInput, SeatingCapacity = SeatingCapacityInput WHERE MeetingRoomId = MeetingRoomIdInput;
END$$

DELIMITER ;
