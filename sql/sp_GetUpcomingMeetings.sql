USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetUpcomingMeetings`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetUpcomingMeetings` (IN EmailInput varchar(45))
BEGIN
select ID into @userid from tbl_users where Email = EmailInput;
select m.*
from tbl_meeting m
join tbl_attendee a
on m.meetingId=a.meetingId
where a.userId=@userid
and m.StartTme >=current_timestamp();
END$$

DELIMITER ;

