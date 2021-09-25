USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_AddAttendeeByUserEmailIdAndMeetingId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_AddAttendeeByUserEmailIdAndMeetingId` (IN AttendeeEmailIdInput varchar(45),IN MeetingRoomIdInput INT)
BEGIN
	SELECT ID INTO @userid FROM tbl_users WHERE Email= AttendeeEmailIdInput;
	INSERT INTO tbl_attendee VALUES (MeetingRoomIdInput,@userid);
END$$

DELIMITER ;