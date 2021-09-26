USE `meeting_room_booking_db`;
DROP VIEW IF EXISTS `vw_classroom`;

CREATE VIEW vw_classroom AS
SELECT mr.MeetingRoomId
FROM tbl_meetingroom mr
JOIN tbl_meeting_room_amenities mra
JOIN tbl_amenities a
ON mr.MeetingRoomId = mra.MeetingRoomId
AND a.AmenityId = mra.AmenityId
WHERE a.AmenityName IN ("whiteboard","projector")
GROUP BY mr.MeetingRoomId
HAVING COUNT(mr.MeetingRoomId) >= 2;