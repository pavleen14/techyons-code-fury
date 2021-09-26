use meeting_room_booking_db;

SELECT * FROM tbl_amenities;
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('1', 'projector', '5');
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('2', 'wifi connection', '10');
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('3', 'conference call facility', '15');
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('4', 'whiteboard', '5');
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('5', 'water dispenser', '5');
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('6', 'tv', '10');
INSERT INTO `tbl_amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('7', 'coffee machine', '10');

select * from tbl_users;
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user1','user1@gmail.com','9876523455',0,'Admin','password1',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user2','user2@gmail.com','9876523455',0,'Admin','password2',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user3','user3@gmail.com','9876523455',0,'Admin','password3',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user4','user4@gmail.com','9876523455',2000,'Manager','password4',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user5','user5@gmail.com','9876523455',2000,'Manager','password5',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user6','user6@gmail.com','9876523455',2000,'Manager','password6',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user7','user7@gmail.com','9876523455',0,'Member','password7',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user8','user8@gmail.com','9876523455',0,'Member','password8',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user9','user9@gmail.com','9876523455',0,'Member','password9',curdate());
insert into tbl_users(Name,Email,Phone,Credits,Role,Password,LastLogin) values('user10','user10@gmail.com','9876523455',0,'Member','password10',curdate());

select * from tbl_meetingroom;
insert into tbl_meetingroom(MeetingRoomId,Name,SeatingCapacity) values(1,'first meeting room',20);
insert into tbl_meetingroom(MeetingRoomId,Name,SeatingCapacity) values(2,'second meeting room',20);
insert into tbl_meetingroom(MeetingRoomId,Name,SeatingCapacity) values(3,'third meeting room',20);

select * from tbl_meeting;
insert into tbl_meeting values(1,'first meeting',4,'2021-01-23 12:45:56','2021-01-23 1:30:56','CONFERENCE_CALL',1,4);
insert into tbl_meeting values(2,'second meeting',5,'2021-01-23 1:31:56','2021-01-23 2:00:56','CONFERENCE_CALL',2,5);
insert into tbl_meeting values(3,'third meeting',6,'2021-01-23 2:01:56','2021-01-23 2:15:56','CONFERENCE_CALL',3,6);

select * from tbl_attendee;
insert into tbl_attendee values(1,1);
insert into tbl_attendee values(2,1);
insert into tbl_attendee values(3,1);

select * from tbl_feedback;
insert into tbl_feedback values(1,5,"comment",7,1);
insert into tbl_feedback values(2,1,"comment",8,1);
insert into tbl_feedback values(3,2,"comment",9,2);

select * from tbl_meeting_room_amenities;
insert into tbl_meeting_room_amenities value(1,1);
insert into tbl_meeting_room_amenities value(2,1);
insert into tbl_meeting_room_amenities value(3,1);
insert into tbl_meeting_room_amenities value(1,2);
insert into tbl_meeting_room_amenities value(2,2);
insert into tbl_meeting_room_amenities value(3,3);
