USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetAmenitiesNameByMeetingRoomName`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetAmenitiesNameByMeetingRoomName` (IN RoomNameInput varchar(45))
BEGIN
	select MeetingRoomId into @roomid from tbl_meetingroom where Name = RoomNameInput;
	select AmenityName from tbl_amenities a join tbl_meeting_room_amenities b on MeetingRoomId=@roomid where a.AmenityId = b.AmenityId; 
END$$

DELIMITER ;

