USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_CheckRowsCountInUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_CheckRowsCountInUsers` ()
BEGIN
	SELECT COUNT(*) FROM tbl_users;

END$$

DELIMITER ;






