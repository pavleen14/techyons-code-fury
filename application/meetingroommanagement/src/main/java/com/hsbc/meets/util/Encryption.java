package com.hsbc.meets.util;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.hsbc.meets.factory.LoggerFactory;

import java.security.MessageDigest;  

/**
 * Encrypts the user password.
 * 
 * @author rishi
 *
 */
public class Encryption {
	static Logger logger = LoggerFactory.getLogger();
	
	/**
	 * Applies MD5 encryption to
	 * the user password.
	 * 
	 * @param password in normal string
	 * @return encrypted password
	 */
	public static String md5(String password)   
	{
		String encryptedPassword = null;

		try   
		{  
			/* MessageDigest instance for MD5. */  
			MessageDigest m = MessageDigest.getInstance("MD5");  

			/* Add plain-text password bytes to digest using MD5 update() method. */  
			m.update(password.getBytes());  

			/* Convert the hash value into bytes */   
			byte[] bytes = m.digest();  

			/* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
			StringBuilder s = new StringBuilder();  
			for(int i=0; i< bytes.length ;i++)  
			{  
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
			}  

			/* Complete hashed password in hexadecimal format */  
			encryptedPassword = s.toString();  
		}   
		catch (NoSuchAlgorithmException e)   
		{  
			logger.log(Level.SEVERE, e.getMessage(), e);
		}  

		return encryptedPassword;
	}  

}