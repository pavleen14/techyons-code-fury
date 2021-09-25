USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetRecent_FeedbackPendingMeetings`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetRecent_FeedbackPendingMeetings` (IN EmailInput varchar(45))
BEGIN
select ID into @userid from tbl_users where Email = EmailInput;
	select x.meetingroomid from(
select distinct m.meetingroomid
from
tbl_meeting m 
join tbl_attendee a
on m.meetingId=a.meetingId 
where a.userId=@userid
)x
where x.meetingroomid not in (select distinct meetingroomid from tbl_feedback where userid=@userid);
END$$

DELIMITER ;

