USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetRecent_FeedbackPendingMeetings`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetRecent_FeedbackPendingMeetings` (IN EmailInput varchar(45))
BEGIN
SELECT ID INTO @userid FROM tbl_users WHERE Email = EmailInput;

SELECT m.Title , m.TypeOfMeeting , mr.Name , mr.MeetingRoomId , m.OrganizedBy , a.UserId
FROM tbl_meetingroom mr
JOIN tbl_meeting m
JOIN tbl_attendee a
ON mr.MeetingRoomId = m.MeetingRoomId
AND m.MeetingId = a.MeetingId
WHERE m.StartTme > NOW() - Interval 7 Day AND
mr.MeetingRoomId NOT IN (
SELECT f.MeetingRoomId 
From tbl_feedback f WHERE f.UserId = @userid
) AND a.userID = @userId;

END$$

DELIMITER ;
