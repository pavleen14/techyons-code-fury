USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_getSeatingCapacityInMeetingRoom`;

DELIMITER $$

CREATE PROCEDURE `sp_getSeatingCapacityInMeetingRoom` (
    IN MeetingRoomIdIn INT
)
BEGIN
	SELECT SeatingCapacity 
	FROM tbl_meetingroom
	WHERE MeetingRoomId = MeetingRoomIdIn;
END $$

DELIMITER ;