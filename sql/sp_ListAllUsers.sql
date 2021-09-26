USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_ListAllUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_ListAllUsers` (IN user_name varchar(50))
BEGIN
	SELECT Name FROM tbl_users WHERE Name LIKE CONCAT(user_name,'%');
END$$

DELIMITER ;
