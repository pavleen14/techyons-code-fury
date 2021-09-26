USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_getAmenitiesInMeetingRoom`;

DELIMITER $$

CREATE PROCEDURE `sp_getAmenitiesInMeetingRoom` (
    IN MeetingRoomIdIn INT
)
BEGIN
	SELECT a.AmenityName 
	FROM tbl_amenities a
	JOIN tbl_meeting_room_amenities m
	ON m.AmenityId = a.AmenityId
	WHERE m.MeetingRoomId = MeetingRoomIdIn;
END $$

DELIMITER ;