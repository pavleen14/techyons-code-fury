DROP TRIGGER IF EXISTS tr_UpdatePerHourCostOnInsertAmenities;
delimiter //
create trigger tr_UpdatePerHourCostOnInsertAmenities
after insert 
on tbl_meeting_room_amenities
for each row
update tbl_meetingroom set perHourCost=(select sum(AmenityCost) from tbl_amenities a join (select * from tbl_meeting_room_amenities
 where MeetingRoomId=NEW.MeetingRoomId)x  on a.amenityId= x.amenityId)+
case when seatingcapacity<=5 then 0 
when seatingcapacity>5 and seatingcapacity<=10 then 10
else 20
end
where MeetingRoomId= NEW.MeetingRoomId;//
delimiter ;