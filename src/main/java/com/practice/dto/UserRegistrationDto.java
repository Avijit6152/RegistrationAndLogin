package com.practice.dto;

public class UserRegistrationDto {

	
	private String uname;
	private String uemail;
	private String upassword;
	
	
	
	
	public UserRegistrationDto(String uname, String uemail, String upassword) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	
}
