USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetRecent_FeedbackPendingMeetings`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetRecent_FeedbackPendingMeetings` (IN EmailInput varchar(45))
BEGIN
SELECT ID INTO @userid FROM tbl_users WHERE Email = EmailInput;
	SELECT x.meetingroomid FROM(
SELECT DISTINCT m.meetingroomid
FROM
tbl_meeting m 
JOIN tbl_attendee a
ON m.meetingId=a.meetingId 
WHERE a.userId=@userid
)x
WHERE x.meetingroomid NOT IN (SELECT DISTINCT meetingroomid FROM tbl_feedback WHERE userid=@userid);
END$$

DELIMITER ;

