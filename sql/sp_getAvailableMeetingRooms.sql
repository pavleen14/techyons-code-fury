USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_getAvailableMeetingRooms`;

DELIMITER $$

CREATE PROCEDURE `sp_getAvailableMeetingRooms` (
	IN startTmeIn DATETIME,
    IN endTimeIn DATETIME,
    IN capacityIn INT,
    IN typeOfMeetingIn enum('CLASSROOM_TRAINING','ONLINE_TRAINING','CONFERENCE_CALL','BUSINESS')
)
BEGIN
IF typeOfMeetingIn = 'CLASSROOM_TRAINING' THEN
    SELECT mr.MeetingRoomId , mr.Name , mr.SeatingCapacity , mr.PerHourCost , mr.Rating, mr.NumberOfFeedbacks
    FROM tbl_meetingroom mr
    LEFT JOIN tbl_meeting m
    ON m.MeetingRoomId = mr.MeetingRoomId
    WHERE mr.MeetingRoomId 
    IN (SELECT MeetingRoomId FROM vw_classroom)
    AND mr.SeatingCapacity >= capacityIn
    AND ( m.StartTme IS NULL
    OR (m.StartTme >= endTimeIn
    OR m.EndTime <= startTmeIn ));
ELSEIF typeOfMeetingIn = 'ONLINE_TRAINING' THEN
    SELECT mr.MeetingRoomId , mr.Name , mr.SeatingCapacity , mr.PerHourCost , mr.Rating, mr.NumberOfFeedbacks
    FROM tbl_meetingroom mr
    LEFT JOIN tbl_meeting m
    ON m.MeetingRoomId = mr.MeetingRoomId
    WHERE mr.MeetingRoomId 
    IN (SELECT MeetingRoomId FROM vw_online)
    AND mr.SeatingCapacity >= capacityIn
    AND ( m.StartTme IS NULL
    OR (m.StartTme >= endTimeIn
    OR m.EndTime <= startTmeIn ));
ELSEIF typeOfMeetingIn = 'CONFERENCE_CALL' THEN
    SELECT mr.MeetingRoomId , mr.Name , mr.SeatingCapacity , mr.PerHourCost , mr.Rating, mr.NumberOfFeedbacks
    FROM tbl_meetingroom mr
    LEFT JOIN tbl_meeting m
    ON m.MeetingRoomId = mr.MeetingRoomId
    WHERE mr.MeetingRoomId 
    IN (SELECT MeetingRoomId FROM vw_conference)
    AND mr.SeatingCapacity >= capacityIn
    AND ( m.StartTme IS NULL
    OR (m.StartTme >= endTimeIn
    OR m.EndTime <= startTmeIn ));
ELSE
    SELECT mr.MeetingRoomId , mr.Name , mr.SeatingCapacity , mr.PerHourCost , mr.Rating, mr.NumberOfFeedbacks
    FROM tbl_meetingroom mr
    LEFT JOIN tbl_meeting m
    ON m.MeetingRoomId = mr.MeetingRoomId
    WHERE mr.MeetingRoomId 
    IN (SELECT MeetingRoomId FROM vw_business)
    AND mr.SeatingCapacity >= capacityIn
    AND ( m.StartTme IS NULL
    OR (m.StartTme >= endTimeIn
    OR m.EndTime <= startTmeIn ));
    END IF;
END $$

DELIMITER ;
