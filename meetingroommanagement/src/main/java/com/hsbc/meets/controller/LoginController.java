package com.hsbc.meets.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meets.entity.*;
import com.hsbc.meets.exception.InvalidCredentialsException;
import com.hsbc.meets.factory.LoginFactory;
import com.hsbc.meets.service.LoginService;

/**
 * This controller handles user
 * 
 * @author
 *
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	/**
	 * This method forwards GET request to the Login Page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/login.jsp");
		dispatcher.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		LoginService service = LoginFactory.getLoginService();
		User user;
		try {
			user = service.authentication(email, password);
			String destPage = "";
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			destPage = user.getRole().toString().toLowerCase();
			System.out.println(destPage);
			try {
				resp.sendRedirect(destPage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (InvalidCredentialsException e) {
			e.printStackTrace();
			try {
				resp.getWriter().write("Invalid Credentials");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			try {
				resp.getWriter().write("Something went wrong. Try again later");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
