delimiter //
create trigger feedback_ins 
after insert 
on feedback
for each row
update meetingroom set rating=(select avg(Rating) from Feedback where MeetingRoomId= NEW.MeetingRoomId), 
NumberOfFeedbacks= coalesce(NumberOfFeedbacks,0)+1 
where MeetingRoomId= NEW.MeetingRoomId;//
delimiter ;
