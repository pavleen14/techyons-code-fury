USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_CheckIfMeetingTitleAlreadyExists`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckIfMeetingTitleAlreadyExists` (IN RooomNameInput varchar(45))
BEGIN
	select Name from tbl_meeting_room where Name = RooomNameInput;
END$$

DELIMITER ;

