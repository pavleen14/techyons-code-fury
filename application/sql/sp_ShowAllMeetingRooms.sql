USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_ShowAllMeetingRooms`;

DELIMITER $$
CREATE PROCEDURE `sp_ShowAllMeetingRooms` ()
BEGIN
	SELECT 
    mr.MeetingRoomId,
    mr.Name,
    mr.SeatingCapacity,
    mr.Rating,
    mr.PerHourCost,
    a.AmenityName
    FROM tbl_meetingroom mr
    JOIN tbl_meeting_room_amenities mra
    JOIN tbl_amenities a
    ON mra.MeetingRoomId = mr.MeetingRoomId
    AND a.AmenityId = mra.AmenityId;
END $$

DELIMITER ;
