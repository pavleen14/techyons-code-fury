package com.hsbc.meets.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.meets.factory.HomeFactory;
import com.hsbc.meets.service.HomeService;
import com.hsbc.meets.util.Connectivity;

/**
 * Handles the requests to
 * GET Home page of the application and
 * import users from XML to database.
 * 
 * @author rishi
 *
 */

@WebServlet("/home")
public class HomeController extends HttpServlet {
	/**
	 * <ol>
	 * 	<li>Returns list of users if
	 * 		'search' parameter is sent in request.</li>
	 * 	<li>Forwards the request control to homepage if 'search' is null.</li>
	 * </ol>
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchString = req.getParameter("search");
		
		if(searchString != null) {
			HomeService service = HomeFactory.getHomeService();
			String matchedUsersJsonString = service.searchUsersByName(searchString);
			resp.getWriter().write(matchedUsersJsonString);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/home.jsp");
			dispatcher.forward(req, resp);
		}
	}

	/**
	 * Fetches the instance of appropriate service class
	 * to handle import users request. 
	 * 
	 * @return import status message of XML file to database
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeService service = HomeFactory.getHomeService();
		String importStatus = service.importUsers();

		resp.getWriter().write(importStatus);
	}
	
	/**
	 * Closes the Connection.
	 */
	@Override
	public void destroy() {
		Connectivity.closeConnection();
		super.destroy();
	}
}
