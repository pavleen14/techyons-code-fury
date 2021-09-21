package com.hsbc.meets.util;

import java.util.regex.Pattern;

import com.hsbc.meets.entity.User;

public class Validator {
	private static Pattern pattern;
	
	public boolean validateUser(User user) {
		return validateName(user.getName()) && validateEmail(user.getEmail()) && validatePhone(user.getPhone()) && validateCredits(user.getRole(), user.getCredits()) && validatePassword(user.getPassword());
	}
	
	private boolean validateName(String name) {
		final String nameRegex = "^[\\p{L} ]+$";
		pattern = Pattern.compile(nameRegex);
		
		if(name == null || name == "")
			return false;
		
		return pattern.matcher(name).matches();
	}
	
	private boolean validateEmail(String email) {
		final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		pattern = Pattern.compile(emailRegex);
		
		if(email == null || email == "")
			return false;
		
		return pattern.matcher(email).matches();
	}
	
	private boolean validatePhone(String phone) {
		final String phoneRegex = "^(?!0+$)(\\+91)?[7-9][0-9]{9}$";
		pattern = Pattern.compile(phoneRegex);
		
		if(phone == null || phone == "")
			return false;
		
		return pattern.matcher(phone).matches();
	}

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
	private boolean validatePassword(String password) {
		final String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		pattern = Pattern.compile(passwordRegex);
		
		if(password == null || password == "")
			return false;
		
		return pattern.matcher(password).matches();
	}
}
