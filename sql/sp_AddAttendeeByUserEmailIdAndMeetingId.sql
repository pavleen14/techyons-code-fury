USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_AddAttendeeByUserEmailIdAndMeetingId`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_AddAttendeeByUserEmailIdAndMeetingId` (IN AttendeeEmailIdInput varchar(45),IN MeetingRoomIdInput INT)
BEGIN
	select ID into @userid from tbl_users where Email= AttendeeEmailIdInput;
	insert into tbl_attendee values (MeetingRoomIdInput,@userid);
END$$

DELIMITER ;