package com.hsbc.meets.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.factory.LoggerFactory;

/**
 * Deals with data transformation.
 * 
 * @author rishi
 *
 */
public class Converter {
	static Logger logger = LoggerFactory.getLogger();
	
	/**
	 * Converts list of User objects to a JSON string.
	 * 
	 * @param users list
	 * @return Json string of list of User objects
	 */
	public static String objectToJsonString(List<User> users) {		
		ObjectMapper mapper = new ObjectMapper();
		String userDetailsStr = "";
		try {
			userDetailsStr = mapper.writeValueAsString(users);
		} catch (JsonProcessingException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return userDetailsStr;		
	}
}
