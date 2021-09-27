USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetUpcomingMeetings`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetUpcomingMeetings` (IN EmailInput varchar(45))
BEGIN
select ID into @userid from tbl_users where Email = EmailInput;
select m.Title, m.TypeOfMeeting , mr.Name , mr.MeetingRoomId , m.Name , m.StartTme
from ( SELECT u.Name,m.* FROM tbl_meeting m JOIN tbl_users u ON u.ID = m.OrganizedBy) m
join tbl_attendee a
join tbl_meetingroom mr
on m.meetingId=a.meetingId
AND mr.MeetingRoomId = m.MeetingRoomId
where a.userId=@userid
and m.StartTme >= NOW();
END$$

DELIMITER ;