USE `meeting_room_booking_db`;
DROP PROCEDURE IF EXISTS `sp_InsertFeedback`;

DELIMITER $$
USE `meeting_room_booking_db`$$
CREATE PROCEDURE `sp_InsertFeedback` (IN RatingInput INT, IN CommentsInput VARCHAR(45), IN UserIdInput INT, IN MeetingRoomIdInput INT)
BEGIN
	 INSERT INTO  tbl_feedback VALUES(ceiling(RAND()*100000),RatingInput,CommentsInput,UserIdInput,MeetingRoomIdInput);
END$$

DELIMITER ;
