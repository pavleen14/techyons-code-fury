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
 * This controller handles the requests from 
 * the Home Page of our application
 * @author rishi
 *
 */

@WebServlet("/")
public class HomeController extends HttpServlet {
	/**
	 * This method forwards GET request to the Home Page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/home.jsp");
		dispatcher.forward(req, resp);
	}
	
	/**
	 * This method handles the import users requests
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HomeService service = HomeFactory.getHomeService();
		boolean usersImported = service.importUsers();
		// TODO return PrintWrite me true
	}
}
