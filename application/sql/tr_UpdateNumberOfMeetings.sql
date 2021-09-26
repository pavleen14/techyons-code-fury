DROP TRIGGER tr_UpdateNumberOfMeetings IF EXISTS; 
delimiter $$
create trigger tr_UpdateNumberOfMeetings
after insert
on tbl_meeting
for each row

update tbl_meetingroom set
NumberOfMeetings= coalesce(NumberOfMeetings,0)+1 
where MeetingRoomId= NEW.MeetingRoomId;
$$
delimiter ;
