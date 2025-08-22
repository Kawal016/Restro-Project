package com.restro.model;

public class ContactPojo {

	private int sno;
	private String name;
	private String email;
	private String subject;
	private String message;
	private String dateTime;
	
	
	
	public ContactPojo(int sno, String name, String email, String subject, String message, String dateTime) {
		super();
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.dateTime = dateTime;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "ContactPojo [sno=" + sno + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + ", dateTime=" + dateTime + "]";
	}
	
	
}
