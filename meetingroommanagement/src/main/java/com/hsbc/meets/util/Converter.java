package com.hsbc.meets.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.meets.entity.User;

/**
 * Deals with data transformation.
 * 
 * @author rishi
 *
 */
public class Converter {
	
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
			e.printStackTrace();
		}
		return userDetailsStr;		
	}
}
