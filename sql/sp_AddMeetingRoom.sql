USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_AddMeetingRoom`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AddMeetingRoom`(IN NameInput Varchar(45), IN SeatingCapacityInput INT )
BEGIN
insert into tbl_meetingroom(MeetingRoomId,Name,SeatingCapacity) values( ceiling(RAND()*1000000),NameInput,SeatingCapacityInput);
select MeetingRoomId from tbl_meetingroom where Name = NameInput;
END$$

DELIMITER ;
;

