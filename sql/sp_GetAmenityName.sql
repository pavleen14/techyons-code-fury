USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_GetAmenityName`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetAmenityName` ()
BEGIN
	SELECT AmenityName FROM tbl_amenities;

END$$

DELIMITER ;
