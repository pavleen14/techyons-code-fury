USE `meeting_room_booking_db`;
DROP VIEW IF EXISTS `vw_conference`;

CREATE VIEW vw_conference AS
SELECT mr.MeetingRoomId
FROM tbl_meetingroom mr
JOIN tbl_meeting_room_amenities mra
JOIN tbl_amenities a
ON mr.MeetingRoomId = mra.MeetingRoomId
AND a.AmenityId = mra.AmenityId
WHERE a.AmenityName = "conference call facility"
GROUP BY mr.MeetingRoomId
HAVING COUNT(mr.MeetingRoomId) >= 2;