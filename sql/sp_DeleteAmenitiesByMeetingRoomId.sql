USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_DeleteAmenitiesByMeetingRoomId`;
DELIMITER $$
USE `meeting_room_booking_db` $$

CREATE PROCEDURE `sp_DeleteAmenitiesByMeetingRoomId` (IN MeetingRoomIdInput INT) BEGIN 
DELETE FROM 
  tbl_meeting_room_amenities 
WHERE 
  MeetingRoomId = MeetingRoomIdInput;
UPDATE 
  tbl_meetingroom 
SET 
  perHourCost = case WHEN seatingcapacity <= 5 then 0 when seatingcapacity > 5 
  and seatingcapacity <= 10 then 10 else 20 end 
WHERE 
  MeetingRoomId = MeetingRoomIdInput;
END$$
DELIMITER ;
