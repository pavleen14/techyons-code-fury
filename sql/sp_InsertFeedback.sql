USE `meeting_room_booking_db`;
DROP procedure IF EXISTS `sp_InsertFeedback`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertFeedback` (IN RatingInput INT, IN CommentsInput varchar(45), IN UserIdInput Int, IN MeetingRoomIdInput INT)
BEGIN
	 insert into  tbl_feedback values(ceiling(RAND()*100000),RatingInput,CommentsInput,UserIdInput,MeetingRoomIdInput);
END$$

DELIMITER ;
