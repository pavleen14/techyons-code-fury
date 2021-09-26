USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_AddMeetingRoom`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AddMeetingRoom`(IN NameInput Varchar(45), IN SeatingCapacityInput INT )
BEGIN
INSERT INTO tbl_meetingroom(MeetingRoomId,Name,SeatingCapacity) VALUES( ceiling(RAND()*1000000),NameInput,SeatingCapacityInput);
SELECT MeetingRoomId FROM tbl_meetingroom WHERE Name = NameInput;
END$$

DELIMITER ; 

