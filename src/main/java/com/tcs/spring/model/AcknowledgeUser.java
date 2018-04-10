package com.tcs.spring.model;

public class AcknowledgeUser {
	String user;
	String datetime;
	public AcknowledgeUser(){}
	public AcknowledgeUser(String user, String datetime) {
		super();
		this.user = user;
		this.datetime = datetime;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
