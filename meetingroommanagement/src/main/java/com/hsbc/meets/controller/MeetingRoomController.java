package com.hsbc.meets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meets.dao.impl.MeetingRoomImpl;
import com.hsbc.meets.exception.MeetingRoomAlreadyExistsException;
import com.hsbc.meets.factory.MeetingRoomFactory;


@WebServlet("/roomController/*")
public class MeetingRoomController extends HttpServlet {

	MeetingRoomImpl dao;
	ServletContext context;
//	MeetingRoomFactory factory; 

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
		
				MeetingRoomFactory.serviceFactory().showAllMeetingRooms(req, resp);
				
			} else if(path.equals("create")) {
				req.getRequestDispatcher("/addNewRoom.jsp").forward(req, resp);
			}
			else if (path.equals("add")) {
				try {
					MeetingRoomFactory.serviceFactory().addMeetingRoom(req, resp);

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
	
}