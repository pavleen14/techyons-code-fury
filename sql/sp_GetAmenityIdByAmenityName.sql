USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_GetAmenityIdByAmenityName`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_GetAmenityIdByAmenityName` (IN NameInput Varchar(30))
BEGIN
	SELECT AmenityId FROM tbl_amenities WHERE AmenityName = NameInput;

END$$

DELIMITER ;