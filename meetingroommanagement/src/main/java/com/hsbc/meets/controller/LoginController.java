package com.hsbc.meets.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.factory.LoginFactory;
import com.hsbc.meets.service.LoginService;

/**
 * This is Login Controller handling authentication and authorization of user 
 * @author Muskan
 *
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	/**
	 * This method forward the Login page for the get request of login page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/login.jsp");
		dispatcher.forward(req, resp);
	}
	/**
	 * This method takes email and password for user 
	 * authentication and forwards it to the authorized page
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		LoginService service = LoginFactory.getLoginService();
		User user;
		HttpSession session = null;
		try {
			user = service.authentication(email, password);
			String destPage = "";
			session = req.getSession();
			session.setAttribute("user", user);
			destPage = user.getRole().toString().toLowerCase();
			try {
				resp.sendRedirect(destPage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (InvalidCredentialsException e) {
			e.printStackTrace();
			try {
				session = req.getSession();
				session.setAttribute("email", email);
				session.setAttribute("message", "Invalid Credentials");
				RequestDispatcher dispatcher =  req.getRequestDispatcher("views/login.jsp");
				try {
					dispatcher.forward(req, resp);
				} catch (ServletException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			try {
				session = req.getSession();
				session.setAttribute("email", email);
				session.setAttribute("message", "Something went wrong!!! Try again later");
				RequestDispatcher dispatcher =  req.getRequestDispatcher("views/login.jsp");
				try {
					dispatcher.forward(req, resp);
				} catch (ServletException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
