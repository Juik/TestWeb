package com.pb.entity;

public class User {
	private int id;
	private String userName;
	private String userPassword;
	private String authority;

	public User() {
		userName = "";
		userPassword = "";
		authority = "";
	}

	public User(int inputID, String inputUserName, String inputUserPassword,
			String inputAuthority) {
		this.id = inputID;
		this.userName = inputUserName;
		this.userPassword = inputUserPassword;
		this.authority = inputAuthority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
