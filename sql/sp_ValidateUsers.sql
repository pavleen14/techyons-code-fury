USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_ValidateUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_ValidateUsers` (IN emailinput varchar(45),IN passwordinput varchar(32))
BEGIN
	SELECT ID,Name,Email,Phone,Credits,Role,LastLogin FROM tbl_users WHERE Email=emailinput AND Password= passwordinput;
END$$

DELIMITER ;