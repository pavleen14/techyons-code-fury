USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_CheckIfMeetingTitleAlreadyExists`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckIfMeetingTitleAlreadyExists` (IN RooomNameInput VARCHAR(45))
BEGIN
	SELECT Title FROM tbl_meeting WHERE Title = RooomNameInput;
END$$

DELIMITER ;



