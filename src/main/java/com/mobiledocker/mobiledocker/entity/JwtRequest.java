package com.mobiledocker.mobiledocker.entity;

public class JwtRequest {
	private String userName;
	private String userPassword;

	public JwtRequest(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public JwtRequest() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "JwtRequest [userName=" + userName + ", userPassword=" + userPassword + "]";
	}

}
