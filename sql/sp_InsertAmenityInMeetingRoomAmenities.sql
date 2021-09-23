USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_InsertAmenityInMeetingRoomAmenities`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertAmenityInMeetingRoomAmenities` (IN AmenityIdInput INT, IN MeetingRoomIdInput INT)
BEGIN
INSERT INTO tbl_meeting_room_amenities (AmenityId,MeetingRoomId) VALUES (AmenityIdInput, MeetingRoomIdInput );
END$$

DELIMITER ;
