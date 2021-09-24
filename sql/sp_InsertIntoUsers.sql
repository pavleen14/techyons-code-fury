USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_InsertIntoUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertIntoUsers` ( IN NameInput varchar(45),IN EmailInput varchar(45),IN PhoneInput varchar(13),IN CreditsInput INT, IN RoleInput varchar(10),IN PasswordInput varchar(32))
BEGIN
		INSERT INTO tbl_users (Name, Email, Phone, Credits, Role, Password) VALUES(NameInput,EmailInput,PhoneInput,CreditsInput,RoleInput,PasswordInput);
END$$

DELIMITER ;

