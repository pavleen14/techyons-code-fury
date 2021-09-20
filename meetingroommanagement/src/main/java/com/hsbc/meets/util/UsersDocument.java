package com.hsbc.meets.util;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.hsbc.meets.entity.User;

@XmlRootElement
public class UsersDocument {
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
