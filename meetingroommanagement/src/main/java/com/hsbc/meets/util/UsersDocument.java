package com.hsbc.meets.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.hsbc.meets.entity.User;

/**
 * Acts as a wrapper while parsing
 * all users' data from XML file.
 * 
 * @author rishi
 *
 */
@XmlRootElement
public class UsersDocument {
	private List<User> users;

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
