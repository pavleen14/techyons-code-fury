package com.hsbc.meets.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidByMeetingTypeException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.exception.NotEnoughCreditsException;
import com.hsbc.meets.exception.NotEnoughSeatsException;
import com.hsbc.meets.exception.SlotNotAvailableException;
import com.hsbc.meets.exception.SomethingWentWrongException;
import com.hsbc.meets.exception.UsersAlreadyExistException;
import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.factory.MeetingFactory;
import com.hsbc.meets.service.HomeService;
import com.hsbc.meets.service.MeetingService;
import com.hsbc.meets.util.Role;

/**
 * @author alan
 *
 */
@WebServlet("/meeting/*")
public class MeetingBookingController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User currentUser = (User) req.getSession().getAttribute("user");
		if(currentUser == null || currentUser.getRole() != Role.MANAGER) {
			resp.sendRedirect("/meetingroommanagement/login");
			return;
		}
		
		String query = req.getParameter("search");
		HomeService hs = HomeFactory.getHomeService();
		String users = hs.searchUsersByName(query);
		PrintWriter out = resp.getWriter();
		out.print(users);
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * meeting name, meeting type, starttime, endtime 
		 * get the available rooms from the service and return 
		 * to selectMeetingRoom
		 */
		
		/**
		 * meeting room 
		 * dispatch selectAndAddMembers
		 * 
		 */
		
		/**
		 * members list
		 * service
		 */
		User currentUser = (User) req.getSession().getAttribute("user");
		if(currentUser == null || currentUser.getRole() != Role.MANAGER) {
			resp.sendRedirect("http://localhost:8080/meetingroommanagement/login");
			return;
		}
		
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		if (req.getPathInfo() != null) {
			String path = req.getPathInfo().substring(1);
			
			if (path.equals("members")) {
				
				int roomId = Integer.parseInt(req.getParameter("roomId"));
				String roomName = req.getParameter("roomName");
				int capacity = Integer.parseInt(req.getParameter("roomCapacity"));
				
				MeetingRoom room = new MeetingRoom(roomName, roomId);
				Meeting meeting = (Meeting) req.getSession().getAttribute("meeting");
				
				if(meeting == null) {
					resp.sendRedirect("http://localhost:8080/meetingroommanagement/manager");
					return;
				}
				
				MeetingService ms = MeetingFactory.getMeetingServiceObject(currentUser);
				try {
					ms.setMeetingBookingInformation(
							meeting.getMeetingTitle(),
							meeting.getStartDateTime(),
							meeting.getEndDateTime(),
							meeting.getMeetingType());
					meeting.setMeetingRoom(room);
					ms.setBookedMeetingRoom(room);
					req.setAttribute("capacity", capacity);
					req.getSession().setAttribute("meeting", meeting);
					
					req.getRequestDispatcher("/views/searchAndAddMembers.jsp").forward(req, resp);
					
				} catch (MeetingTitleInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingStartDateTimeInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingDurationInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingTypeInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingRoomAmenitiesInvalidByMeetingTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotEnoughSeatsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SlotNotAvailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			else if(path.equals("rooms")) {
				
				
				String title = req.getParameter("title");
				String MeetingType = req.getParameter("meettype");
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
				Calendar stime = Calendar.getInstance();
				Calendar dtime = Calendar.getInstance();
				dtime.add(Calendar.HOUR, 1);
				try {
					stime.setTime(formatter.parse(req.getParameter("stime")));
					dtime.setTime(formatter.parse(req.getParameter("stime")));
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println(title);
				System.out.print(MeetingType);
				Meeting meeting = new Meeting(title, stime,dtime, MeetingType);
				MeetingService ms = MeetingFactory.getMeetingServiceObject(currentUser);
				try {
					ms.setMeetingBookingInformation(title, stime, dtime, MeetingType);
					List<MeetingRoom> rooms = ms.getAllAvailableMeetingRooms();
					req.setAttribute("rooms" , rooms);
					req.getSession().setAttribute("meeting", meeting);
					
					req.getRequestDispatcher("/views/selectMeetingRoom.jsp").forward(req, resp);
				} catch (MeetingTitleInvalidException e) {
					e.printStackTrace();
				} catch (MeetingStartDateTimeInvalidException e) {
					e.printStackTrace();
				} catch (MeetingDurationInvalidException e) {
					e.printStackTrace();
				} catch (MeetingTypeInvalidException e) {
					e.printStackTrace();
				}
				
			}

			else if(path.equals("submit")) {
				
				Meeting meeting = (Meeting) req.getSession().getAttribute("meeting");
				
				if(meeting == null) {
					resp.sendRedirect("http://localhost:8080/meetingroommanagement/manager");
					return;
				}
				
				StringBuffer jb = new StringBuffer();
				String line = null;
				ObjectMapper mapper = new ObjectMapper();
				MeetingService ms = MeetingFactory.getMeetingServiceObject(currentUser);
				
				try (
					BufferedReader reader = req.getReader();	    
				){
				    while ((line = reader.readLine()) != null)
				        jb.append(line);
				    List<User> users = mapper.readValue(jb.toString(), new TypeReference<List<User>>(){});
				    users.add(currentUser);
				    ms.setMeetingBookingInformation(
							meeting.getMeetingTitle(),
							meeting.getStartDateTime(),
							meeting.getEndDateTime(),
							meeting.getMeetingType());
				    ms.setBookedMeetingRoom(meeting.getMeetingRoom());
				    ms.setAttendeesList(users);
				    ms.bookMeeting();
				    
				    resp.sendRedirect("http://localhost:8080/meetingroommanagement/manager");
				} catch (MeetingTitleInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingStartDateTimeInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingDurationInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingTypeInvalidException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MeetingRoomAmenitiesInvalidByMeetingTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotEnoughSeatsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SlotNotAvailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotEnoughCreditsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SomethingWentWrongException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else {	
				resp.sendRedirect("/meetingroommanagement/manager");
				return;
			}
		}
		out.close();
	}
	
}
