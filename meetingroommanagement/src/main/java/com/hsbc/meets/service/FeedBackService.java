package com.hsbc.meets.service;

/**
 *  Helps implement Service class which
 * intends to handle the business 
 * logic of submitting feedback.
 * @author Muskan	
 *
 */
public interface FeedBackService {

	/**
	 * 	
	 * @param roomname
	 * @param id
	 * @param rating
	 * @param comment
	 * @return feedBackStatus
	 */
	public String addFeedBack(int roomname,int id,int rating,String comment);
}
