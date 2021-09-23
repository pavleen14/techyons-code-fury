USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_DeleteAmenitiesByMeetingRoomId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_DeleteAmenitiesByMeetingRoomId` (IN MeetingRoomIdInput INT)
BEGIN
	DELETE FROM tbl_meeting_room_amenities WHERE MeetingRoomId = MeetingRoomIdInput;

END$$

DELIMITER ;