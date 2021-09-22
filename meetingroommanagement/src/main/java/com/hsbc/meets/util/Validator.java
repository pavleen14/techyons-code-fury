package com.hsbc.meets.util;

import java.util.regex.Pattern;

import com.hsbc.meets.entity.User;

/**
 * Validates the fields of user's data.
 * 
 * @author rishi
 *
 */
public class Validator {
	private static Pattern pattern;
	
	/**
	 * Validates the user's data while importing
	 * user into database
	 * 
	 * @param user object to be validated
	 * @return true if all the data of user is in correct format
	 * 
	 */
	public boolean validateUser(User user) {
		boolean isValid = validateName(user.getName()) && validateEmail(user.getEmail()) && validatePhone(user.getPhone()) && validateCredits(user.getRole(), user.getCredits()) && validatePassword(user.getPassword());
		return isValid;
	}
	
	/**
	 * Validates user's name format. Only characters and spaces are allowed
	 * 
	 * @param name to be validated
	 * @return true if name is in correct format
	 * 
	 */
	private boolean validateName(String name) {
		final String nameRegex = "^[\\p{L} ]+$";
		pattern = Pattern.compile(nameRegex);
		
		if(name == null || name == "")
			return false;
		
		return pattern.matcher(name).matches();
	}

	/**
	 * Validates user's email format
	 * 
	 * @param email to be validated
	 * @return true if email is in correct format
	 * 
	 */
	public boolean validateEmail(String email) {
		final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		pattern = Pattern.compile(emailRegex);
		
		if(email == null || email == "")
			return false;
		
		return pattern.matcher(email).matches();
	}

	/**
	 * Validates user's phone format
	 * 
	 * @param phone to be validated
	 * @return true if phone is in correct format
	 * 
	 */
	private boolean validatePhone(String phone) {
		final String phoneRegex = "^(?!0+$)(\\+91)?[7-9][0-9]{9}$";
		pattern = Pattern.compile(phoneRegex);
		
		if(phone == null || phone == "")
			return false;
		
		return pattern.matcher(phone).matches();
	}

	/**
	 * Validates if user's credits and role
	 * 
	 * @param role of user
	 * @param credits of user
	 * @return true if credits are valid for user's role
	 * 
	 */
	private boolean validateCredits(Role role, int credits) {
		if(role == null || role.toString() == "")
			return false;
		// check if ADMIN and MEMBER have zero credits
		if((role == Role.ADMIN || role == Role.MEMBER) && credits == 0)
			return true;
		if(role == Role.MANAGER && (credits >=0 && credits <=2000))
			return true;
		return false;
	}

	/**
	 * Checks if password matches given criteria:
	 * 1. At least one upper case alphabet
	 * 2. At least one lower case alphabet
	 * 3. At least one digit
	 * 4. At least one secial character
	 * 	- allowed special characters: @, #, $, %, ^, &, -, +, =, (, )
	 * 5. Password length between 8-20 charactes
	 * 
	 * @param password
	 * 
	 * @return boolean based on if password is valid or not
	 */
	public boolean validatePassword(String password) {
		final String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		pattern = Pattern.compile(passwordRegex);
		
		if(password == null || password == "")
			return false;
		
		return pattern.matcher(password).matches();
	}
}
