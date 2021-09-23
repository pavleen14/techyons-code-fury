USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_InsertIntoUsers`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertIntoUsers` ( IN NameInput varchar(20),IN EmailInput varchar(30),IN PhoneInput varchar(30),IN CreditsInput INT, IN RoleInput varchar(10),IN PasswordInput varchar(30))
BEGIN
		INSERT INTO tbl_users (ID, Name, Email, Phone, Credits, Role, Password) VALUES(ceiling(RAND()*1000000),NameInput,EmailInput,PhoneInput,CreditsInput,RoleInput,PasswordInput);
END$$

DELIMITER ;

