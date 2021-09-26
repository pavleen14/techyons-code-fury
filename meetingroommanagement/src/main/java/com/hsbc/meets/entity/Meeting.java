package com.hsbc.meets.entity;

import java.util.Calendar;
import java.util.List;
/**
 * 
 * @author ShubhraBhuniaGhosh
 *
 */
public class Meeting {
	private int meetingId;
	private String meetingTitle;
	private Calendar startDateTime;
	private Calendar endDateTime;
	private int durationInMinuts;
	private String meetingType;
	private List<User> attendees;
	private MeetingRoom meetingRoom;
	
	public Meeting(int meetingId){
	}
	
	public Meeting(String meetingTitle, Calendar startDateTime, int durationInMinuts,
			String meetingType) {
		this.meetingId = -1;
		this.meetingTitle = meetingTitle;
		this.startDateTime = startDateTime;
		this.durationInMinuts = durationInMinuts;
		this.meetingType = meetingType;
	}
	
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}

	public Calendar getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Calendar startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Calendar getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Calendar endDateTime) {
		this.endDateTime = endDateTime;
	}
	public int getDurationInMinuts() {
		return durationInMinuts;
	}
	public void setDurationInMinuts(int durationInMinuts) {
		this.durationInMinuts = durationInMinuts;
	}
	public String getMeetingType() {
		return meetingType;
	}
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}
	public List<User> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
	public int getMeetingId() {
		return meetingId;
	}
	
}
