USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_UpdateLastLogin`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_UpdateLastLogin` (IN idinput INT)
BEGIN
	UPDATE tbl_users set LastLogin=CURRENT_TIMESTAMP() where Id=idinput;
END$$

DELIMITER ;

