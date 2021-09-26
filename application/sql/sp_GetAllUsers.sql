USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_GetAllUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetAllUsers` ()
BEGIN
	SELECT Name,Email FROM tbl_users;
END$$

DELIMITER ;

