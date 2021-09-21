use projectdatabase;

SELECT * FROM amenities;
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('1', 'projector', '5');
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('2', 'wifi connection', '10');
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('3', 'conference call facility', '15');
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('4', 'whiteboard', '5');
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('5', 'water dispenser', '5');
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('6', 'tv', '10');
INSERT INTO `projectdatabase`.`amenities` (`AmenityId`, `AmenityName`, `AmenityCost`) VALUES ('7', 'coffee machine', '10');

select * from users;
insert into users values(1,'user1','user1@gmail.com','9876523455',0,'Admin','password1',curdate());
insert into users values(2,'user2','user2@gmail.com','9876523455',0,'Admin','password2',curdate());
insert into users values(3,'user3','user3@gmail.com','9876523455',0,'Admin','password3',curdate());
insert into users values(4,'user4','user4@gmail.com','9876523455',2000,'Manager','password4',curdate());
insert into users values(5,'user5','user5@gmail.com','9876523455',2000,'Manager','password5',curdate());
insert into users values(6,'user6','user6@gmail.com','9876523455',2000,'Manager','password6',curdate());
insert into users values(7,'user7','user7@gmail.com','9876523455',0,'Member','password7',curdate());
insert into users values(8,'user8','user8@gmail.com','9876523455',0,'Member','password8',curdate());
insert into users values(9,'user9','user9@gmail.com','9876523455',0,'Member','password9',curdate());
insert into users values(10,'user10','user10@gmail.com','9876523455',0,'Member','password10',curdate());

select * from meeting;
insert into meeting values(1,'first meeting',4,'2021-01-23 12:45:56','2021-01-23 1:30:56','CONFERENCE_CALL',1,4);
insert into meeting values(2,'second meeting',5,'2021-01-23 1:31:56','2021-01-23 2:00:56','CONFERENCE_CALL',2,5);
insert into meeting values(3,'third meeting',6,'2021-01-23 2:01:56','2021-01-23 2:15:56','CONFERENCE_CALL',3,6);

select * from meetingroom;
insert into meetingroom(MeetingRoomId,Name,SeatingCapacity) values(1,'first meeting room',20);
insert into meetingroom(MeetingRoomId,Name,SeatingCapacity) values(2,'second meeting room',20);
insert into meetingroom(MeetingRoomId,Name,SeatingCapacity) values(3,'third meeting room',20);

select * from attendee;
insert into attendee values(1,1);
insert into attendee values(2,1);
insert into attendee values(3,1);

select * from feedback;
delete from feedback;
insert into feedback values(1,5,"comment",7,1);
insert into feedback values(2,1,"comment",8,1);
insert into feedback values(3,2,"comment",9,2);

select * from meeting_room_amenities;
insert into meeting_room_amenities value(1,1);
insert into meeting_room_amenities value(2,1);
insert into meeting_room_amenities value(3,1);
insert into meeting_room_amenities value(1,2);
insert into meeting_room_amenities value(2,2);
insert into meeting_room_amenities value(3,3);
