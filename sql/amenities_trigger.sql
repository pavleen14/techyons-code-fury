delimiter //
create trigger Meeting_amenities_ins 
after insert 
on meeting_room_amenities
for each row
update MeetingRoom set perHourCost=(select sum(AmenityCost) from amenities a join (select * from meeting_room_amenities
 where MeetingRoomId=NEW.MeetingRoomId)x  on a.amenityId= x.amenityId)+
case when seatingcapacity<=5 then 0 
when seatingcapacity>5 and seatingcapacity<=10 then 10
else 20
end
where MeetingRoomId= NEW.MeetingRoomId;//
delimiter ;