package com.hsbc.meets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.factory.LoginFactory;
import com.hsbc.meets.service.HomeService;
import com.hsbc.meets.service.LoginService;
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
		
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		if (req.getPathInfo() != null) {
			String path = req.getPathInfo().substring(1);
			
			if (path.equals("members")) {
				
		
			}
			
			else if(path.equals("rooms")) {
				
			}

			else if(path.equals("submit")) {
				
			}
			
			else {	
				//members list	
			}
		super.doPost(req, resp);
	}
}
	
}
