USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_InsertAmenityInMeetingRoomAmenities`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertAmenityInMeetingRoomAmenities` (IN AmenityNameInput VARCHAR(30), IN MeetingRoomIdInput INT)
BEGIN
INSERT INTO tbl_meeting_room_amenities (AmenityId,MeetingRoomId) VALUES ( 
  (SELECT AmenityId FROM tbl_amenities WHERE AmenityName=AmenityNameInput) ,
  MeetingRoomIdInput 
);
END$$

DELIMITER ;
