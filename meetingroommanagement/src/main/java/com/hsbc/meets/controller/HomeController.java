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

/**
 * This controller handles the requests to
 * get Home page of our application and
 * import users from XML to MySQL database
 * 
 * @author rishi
 *
 */

@WebServlet("/")
public class HomeController extends HttpServlet {
	/**
	 * Forwards the request control to homepage resource
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/home.jsp");
		dispatcher.forward(req, resp);
	}
	
	/**
	 * Fetches the instance of appropriate service class
	 * to import users
	 * 
	 * @return import status of XML file to database
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeService service = HomeFactory.getHomeService();
		String importStatus = service.importUsers();
		
		resp.getWriter().write(importStatus);
	}
}
