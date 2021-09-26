USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_CheckMeetingRoomCapacityByMeetingRoomId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckMeetingRoomCapacityByMeetingRoomId` (IN RoomIdInput INT)
BEGIN
	SELECT SeatingCapacity FROM tbl_meetingroom WHERE MeetingRoomId = RoomIdInput;
END$$

DELIMITER ;

