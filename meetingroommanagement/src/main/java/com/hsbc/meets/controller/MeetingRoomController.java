package com.hsbc.meets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meets.dao.impl.MeetingRoomDbDaoImpl;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomNameInvalidException;
import com.hsbc.meets.exception.MeetingRoomSeatingCapacityInalidException;
import com.hsbc.meets.factory.MeetingRoomServiceFactory;
import com.hsbc.meets.service.MeetingRoomService;

/**
 * The class is the Controller class
 * for the entity meeting Room. 
 * 
 * @author PavleenKaur
 * @author ShubhraBhuniaGhosh
 *
 */

@WebServlet("/meetingroom")
public class MeetingRoomController extends HttpServlet {

	MeetingRoomDbDaoImpl dao;
	ServletContext context;

	public void init() throws ServletException {
		dao = new MeetingRoomDbDaoImpl();
		context = this.getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		MeetingRoomService meetingRoomService = MeetingRoomServiceFactory.getService();
		
		List<MeetingRoom> allMeetingRooms = meetingRoomService.showAllMeetingRooms();
		req.setAttribute("elist", allMeetingRooms);
		req.getRequestDispatcher("/roomlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		MeetingRoomService meetingRoomService = MeetingRoomServiceFactory.getService();
		try {
			String roomName = req.getParameter("mname");
			int roomCapacity = Integer.parseInt(req.getParameter("mcapacity"));
			List<String> roomAmenities = new ArrayList<String>();
			
			for(String amenity : req.getParameterValues("amenities")) {
				roomAmenities.add(amenity);
			}
	 
			meetingRoomService.addMeetingRoom(roomName,roomCapacity,roomAmenities);
			out.println(true);

		} catch (MeetingRoomAlreadyExistsException r) {

			context.log("Meeting room already exists");
			out.print(false);
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		MeetingRoomService meetingRoomService = MeetingRoomServiceFactory.getService();
		int roomId = Integer.parseInt(req.getParameter("mid"));
		String roomName = req.getParameter("mname");
		int roomCapacity = Integer.parseInt(req.getParameter("mcapacity"));
		List<String> roomAmenities = new ArrayList<String>();
		
		for(String amenity : req.getParameterValues("amenities")) {
			roomAmenities.add(amenity);
		}
		
		try {
			meetingRoomService.editMeetingRoom(roomId, roomName, roomCapacity, roomAmenities);
		} catch (MeetingRoomNameInvalidException | MeetingRoomSeatingCapacityInalidException
				| MeetingRoomAmenitiesInvalidException | MeetingRoomDoesNotExistsException
				| MeetingRoomAlreadyExistsException e) {
			e.printStackTrace();
		}
		
	}
	
}