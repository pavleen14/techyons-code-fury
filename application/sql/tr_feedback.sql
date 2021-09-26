DROP TRIGGER IF EXISTS tr_feedback
delimiter //
create trigger tr_feedback
after insert 
on tbl_feedback
for each row
update tbl_meetingroom set rating=(select avg(Rating) from tbl_feedback where MeetingRoomId= NEW.MeetingRoomId), 
NumberOfFeedbacks= coalesce(NumberOfFeedbacks,0)+1 
where MeetingRoomId= NEW.MeetingRoomId;//
delimiter ;