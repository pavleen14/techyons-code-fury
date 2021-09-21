package com.hsbc.meets.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

import com.hsbc.meets.entity.*;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.dao.impl.MeetingRoomImpl;

@WebServlet("/roomController/*")
public class MeetingRoomController extends HttpServlet {

	MeetingRoomImpl dao;
	ServletContext context;

	public void init() throws ServletException {
		dao = new MeetingRoomImpl();
		context = this.getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		if (req.getPathInfo() != null) {
			String path = req.getPathInfo().substring(1);
			System.out.println(path); 

			if (path.equals("list")) {
				showAllMeetingRooms(req, resp);
				
			} else if(path.equals("create")) {
				req.getRequestDispatcher("/addNewRoom.jsp").forward(req, resp);
			}
			else if (path.equals("add")) {
				try {
					addMeetingRoom(req, resp);

				} catch (MeetingRoomAlreadyExistsException r) {

					context.log("Meeting room already exists");
					req.getRequestDispatcher("/admin.jsp").forward(req, resp);
				}
			}
			else {
				// here the functionality for updateRoom will be added 
				System.out.println(path); 
			}

		}
	}
	public void showAllMeetingRooms(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<MeetingRoom> elist = dao.showAllMeetingRooms();
		req.setAttribute("elist", elist);
		req.getRequestDispatcher("/roomlist.jsp").forward(req, resp);

	}

	public void addMeetingRoom(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, MeetingRoomAlreadyExistsException {
		
		int roomCredits = 0; 
		int creditsPerHour = 0; 
		int sumOfAmenities =0; 
		System.out.println(req.getParameter("mid"));
		System.out.println(req.getParameter("mname"));
		System.out.println(req.getParameter("mcapacity"));


		int roomId = Integer.parseInt(req.getParameter("mid"));
		String roomName = req.getParameter("mname");
		int roomCapacity = Integer.parseInt(req.getParameter("mcapacity"));
		String[] roomAmenities = req.getParameterValues("amenities");
 
		if(roomCapacity <=5)
			roomCredits = 0; 
		else if(roomCapacity >5 && roomCapacity <=10)
			roomCredits = 10; 
		else 
			roomCredits = 20; 
		
		for(int i =0; i<roomAmenities.length; i++) {
			if(roomAmenities[i].equalsIgnoreCase("Projector"))
					sumOfAmenities += 5; 
			if(roomAmenities[i].equalsIgnoreCase("Wifi-Connection"))
					sumOfAmenities += 10; 
			if(roomAmenities[i].equalsIgnoreCase("Conference-Call-Facility"))
				sumOfAmenities += 15;
			if(roomAmenities[i].equalsIgnoreCase("White-Board"))
				sumOfAmenities += 5; 
			if(roomAmenities[i].equalsIgnoreCase("Water-Dispenser"))
				sumOfAmenities += 5;
			if(roomAmenities[i].equalsIgnoreCase("TV"))
				sumOfAmenities += 10;
			if(roomAmenities[i].equalsIgnoreCase("Coffee-Machine"))
				sumOfAmenities += 10;
		}
		
		creditsPerHour = roomCredits + sumOfAmenities; 
		
		MeetingRoom room = new MeetingRoom(roomId,roomName, roomCapacity, roomAmenities, creditsPerHour);
		dao.addMeetingRoom(room);
		showAllMeetingRooms(req, resp);
		
		

	}
}