USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_CheckMeetingRoomCapacityByMeetingRoomId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckMeetingRoomCapacityByMeetingRoomId` (IN RoomIdInput INT)
BEGIN
	select SeatingCapacity from tbl_meetingroom where MeetingRoomId = RoomIdInput;
END$$

DELIMITER ;

