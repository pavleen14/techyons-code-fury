This folder will contain all the sql commands and stored procedure codes

#to validate
select * from tbl_users;
select * from tbl_meeting;
select * from tbl_meetingroom;
select * from tbl_attendee;
select * from tbl_meeting_room_amenities;
select * from tbl_feedback;

#------------------------USER FUNCTIONALITIES---------------------------------------- 

`sp_ValidateUsers`(<{IN emailinput varchar(45)}>, <{IN passwordinput varchar(32)}>); ## returns all details of user if the user is validated
`sp_ListAllUsers`(<{IN user_name varchar(50)}>); # returns all usernames which starts with the given input string
`sp_InsertIntoUsers`(<{IN NameInput varchar(45)}>, <{IN EmailInput varchar(45)}>, <{IN PhoneInput varchar(13)}>, <{IN CreditsInput INT}>, <{IN RoleInput varchar(10)}>, <{IN PasswordInput varchar(32)}>); #-----insert into users
`sp_UpdateLastLogin`(<{IN idinput INT}>);#takes id as input,updates last login

#----------------------------MEETING ROOM---------------------------------------------

`sp_AddMeetingRoom`(<{IN NameInput Varchar(45)}>, <{IN SeatingCapacityInput INT}>); #returns meeting room id
`sp_DeleteAmenitiesByMeetingRoomId`(<{IN MeetingRoomIdInput INT}>); #Returns numbers of rows affected
`sp_ShowAllMeetingRooms`(); #Returns all parameters
`sp_DisplayMeetingRoomExceptId`(); #returns Name, Seating capacity, Rating, PerHourCost, NumberOfFeedbacks
`sp_GetAmenityName`(); #Returns amenity 
`sp_InsertAmenityInMeetingRoomAmenities`(<{IN AmenityNameInput VARCHAR(30)}>, <{IN MeetingRoomIdInput INT}>); #Returns Amenity Id, Meeting room Id
`sp_UpdateMeetingRoomById`(<{IN NameInput varchar(20)}>, <{IN SeatingCapacityInput INT}>, <{IN MeetingRoomIdInput INT}>); #Updates the name for meeting room
`sp_CheckMeetingRoomIfExists`('XYZ'); #Checks if meeting exists

#--------------------------MEETING----------------------------------------------------

`sp_InsertIntoMeeting`(<{IN TitleInput varchar(45)}>, <{IN OrganizedByInput int}>, <{IN StartTimeInput DATETIME}>, <{IN EndTimeInput DATETIME}>, <{IN TypeOfMeetingInput varchar(20)}>, <{IN RoomIdInput INT}>);#insert into meeting 
`sp_AddAttendeeByUserEmailIdAndMeetingId`(<{IN AttendeeEmailIdInput varchar(45)}>, <{IN MeetingIdInput INT}>); #inserts into tbl_attendee -- returns number of rows affected
`sp_GetUpcomingMeetings`(<{IN EmailInput varchar(45)}>); # returns meeting details(all parameters in table) of upcoming meetings 
`sp_GetRecent_FeedbackPendingMeetings`(<{IN EmailInput varchar(45)}>); #return list meetingroom IDs for which  feedback is pending 

#----------------------------FEEDBACK--------------------------------------------------

`sp_InsertFeedback`(<{IN RatingInput INT}>, <{IN CommentsInput VARCHAR(45)}>, <{IN UserIdInput INT}>, <{IN MeetingRoomIdInput INT}>);# --- insert into feedback

#--------------------------------------------------------------------------------------

`sp_InsertIntoMeeting`(<{IN TitleInput varchar(45)}>, <{IN OrganizedByInput int}>, <{IN StartTimeInput DATETIME}>, <{IN EndTimeInput DATETIME}>, <{IN TypeOfMeetingInput varchar(20)}>, <{IN RoomIdInput INT}>);#insert into meeting 
`sp_GetAllUsers`();# returns user details(all parameters)
`sp_GetAmenityIdByAmenityName`(<{IN NameInput Varchar(30)}>); # returns amenity id
`sp_CheckIfMeetingTitleAlreadyExists`(<{IN RooomNameInput varchar(45)}>);#returns meetingroom name if the title already exists
`sp_CheckMeetingRoomCapacityByMeetingRoomId`(<{IN RoomIdInput INT}>);#return seating capacity
`sp_AddAttendeeByUserEmailIdAndMeetingId`(<{IN AttendeeEmailIdInput varchar(45)}>, <{IN MeetingRoomIdInput INT}>);

