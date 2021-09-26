package com.hsbc.meets.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.meets.entity.User;
import com.hsbc.meets.factory.FeedBackFactory;
import com.hsbc.meets.factory.LoggerFactory;
import com.hsbc.meets.service.FeedBackService;
import com.hsbc.meets.util.Connectivity;


/**
 * Getting and Submitting feedback from user
 * 
 * @author Muskan
 *
 */
@WebServlet("/feedback")
public class FeedBackController extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger();

	/**
	 * Forward the request control to feedback page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/feedback.jsp");
		dispatcher.forward(req, resp);
	}

	/**
	 * Sending feedback to service layer
	 *
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = null;
		int roomId = Integer.parseInt(req.getParameter("roomId"));
		int rating = Integer.parseInt(req.getParameter("rating"));
		String comment = req.getParameter("comment");
		HttpSession session = req.getSession();
	    user = (User) session.getAttribute("user");
		FeedBackService service = FeedBackFactory.getFeedBackService();
		String feedBackStatus = "";

		feedBackStatus = service.addFeedBack(roomId,user.getUserId(),rating, comment);
		if(	feedBackStatus.equals("") )
		{
			String destPage = user.getRole().toString().toLowerCase();
			try {
				resp.sendRedirect(destPage);
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}

		}
		else
		{  session.setAttribute("message",feedBackStatus);

			RequestDispatcher dispatcher =  req.getRequestDispatcher("views/feedback.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
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
