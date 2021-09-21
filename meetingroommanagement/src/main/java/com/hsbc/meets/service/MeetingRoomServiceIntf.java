package com.hsbc.meets.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;

public interface MeetingRoomServiceIntf{
	
	public void showAllMeetingRooms(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
	
	public void addMeetingRoom(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, MeetingRoomAlreadyExistsException;

}
