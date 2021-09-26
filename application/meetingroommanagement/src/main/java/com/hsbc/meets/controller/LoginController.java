package com.hsbc.meets.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.factory.LoginFactory;
import com.hsbc.meets.service.LoginService;
import com.hsbc.meets.util.Connectivity;

/**
 * Handling authentication and authorization of user 
 * 
 * @author Muskan
 *
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger();
	
	/**
	 * Forward the request control to login page.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("op");
		if(operation == "logout") {
			req.getSession().invalidate();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/login.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * Authenticates user and forwards it to the 
	 * page based on their Role in their organization.
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		LoginService service = LoginFactory.getLoginService();
		HttpSession session = req.getSession();
		User user = null;

		try {
			user = service.authentication(email, password);
			
			session.setAttribute("user", user);
			
			String destPage = user.getRole().toString().toLowerCase();
			try {
				resp.sendRedirect(destPage);
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		} catch (InvalidCredentialsException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			
			try {
				session.setAttribute("email", email);
				session.setAttribute("message", "Invalid credentials");
				
				RequestDispatcher dispatcher =  req.getRequestDispatcher("views/login.jsp");
				try {
					dispatcher.forward(req, resp);
				} catch (ServletException e1) {
					logger.log(Level.SEVERE, e1.getMessage(), e1);
				}
			} catch (IOException e1) {
				logger.log(Level.SEVERE, e1.getMessage(), e1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			
			try {
				session.setAttribute("email", email);
				session.setAttribute("message", "Something went wrong.\nTry again later.");
				
				RequestDispatcher dispatcher =  req.getRequestDispatcher("views/login.jsp");
				try {
					dispatcher.forward(req, resp);
				} catch (ServletException e1) {
					logger.log(Level.SEVERE, e.getMessage(), e1);
				}
			} catch (IOException e1) {
				logger.log(Level.SEVERE, e.getMessage(), e1);
			}
		}
	}

	/**
	 * Closes the connection.
	 */
	@Override
	public void destroy() {
		Connectivity.closeConnection();
		super.destroy();
	}

}
