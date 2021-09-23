USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_ListAllUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_ListAllUsers` (IN user_name varchar(50))
BEGIN
	select Name from tbl_users where Name LIKE CONCAT(user_name,'%');
END$$

DELIMITER ;
