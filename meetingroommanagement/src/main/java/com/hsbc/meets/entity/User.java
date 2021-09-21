package com.hsbc.meets.entity;

import com.hsbc.meets.util.Role;
import java.time.LocalDateTime;


public class User {
	private int userId;
	private String name;
	private String email;
	private String phone;
	private int credits;
	private Role role;
	private String password;
	private LocalDateTime lastLogin;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", credits="
				+ credits + ", role=" + role + ", password=" + password + ", lastLogin=" + lastLogin + "]";
	}
	
}
