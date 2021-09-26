package com.hsbc.meets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidException;
import com.hsbc.meets.exception.MeetingRoomDoesNotExistsException;
import com.hsbc.meets.exception.MeetingRoomInvalidException;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.factory.MeetingRoomFactory;
import com.hsbc.meets.service.MeetingRoomService;
import com.hsbc.meets.util.Role;

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
	
	private Logger logger = null;
	
	public void init() throws ServletException {
		logger = LoggerFactory.getLogger();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");
		
		User currentUser = (User) req.getSession().getAttribute("user");
		if(currentUser == null || currentUser.getRole() != Role.ADMIN) {
			resp.sendRedirect("/meetingroommanagement/login");
			return;
		}
		
		MeetingRoomService meetingRoomService = MeetingRoomFactory.getService();
		
		List<MeetingRoom> allMeetingRooms = meetingRoomService.showAllMeetingRooms();
		req.setAttribute("elist", allMeetingRooms);
		req.getRequestDispatcher("/roomlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User currentUser = (User) req.getSession().getAttribute("user");
		if(currentUser == null || currentUser.getRole() != Role.ADMIN) {
			resp.sendRedirect("/meetingroommanagement/login");
			return;
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		MeetingRoomService meetingRoomService = MeetingRoomFactory.getService();

		String editflag = req.getParameter("editflag");

		if (editflag == null) {
			String roomName = req.getParameter("mname");
			int roomCapacity = Integer.parseInt(req.getParameter("mcapacity"));
			List<String> roomAmenities = new ArrayList<String>();
			
			for(String amenity : req.getParameterValues("amenities")) {
				roomAmenities.add(amenity);
			}
			try {		
				meetingRoomService.addMeetingRoom(roomName,roomCapacity,roomAmenities);
				resp.sendRedirect("/meetingroommanagement/admin");
			} catch (MeetingRoomAlreadyExistsException r) {
				logger.log(Level.SEVERE,"Meeting Room already exists",r);
			} catch (MeetingRoomAmenitiesInvalidException e) {
				e.printStackTrace();
				logger.log(Level.SEVERE,"Meeting amenities invalid",e);
			}
		} else {
			resp.setContentType("application/json;charset=UTF-8");
			int roomId = Integer.parseInt(req.getParameter("mid"));
			String roomName = req.getParameter("mname");
			int roomCapacity = Integer.parseInt(req.getParameter("mcapacity"));
			List<String> roomAmenities = new ArrayList<String>();
			
			for(String amenity : req.getParameterValues("amenities")) {
				roomAmenities.add(amenity);
			}
			
			try {
				meetingRoomService.editMeetingRoom(roomId, roomName, roomCapacity, roomAmenities);
				resp.sendRedirect("/meetingroommanagement/admin");
			} catch (MeetingRoomInvalidException | MeetingRoomDoesNotExistsException
					| MeetingRoomAlreadyExistsException e) {
				logger.log(Level.SEVERE,"Meeting room edit failed",e);
				
			}
		}
	}
}