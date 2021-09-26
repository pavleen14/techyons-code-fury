USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetMeetingRoom`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetMeetingRoom` (IN RoomIdInput INT)
BEGIN
	SELECT MeetingRoomId, Name, SeatingCapacity
	FROM tbl_meetingroom
	WHERE MeetingRoomId = RoomIdInput;
END$$

DELIMITER ;
