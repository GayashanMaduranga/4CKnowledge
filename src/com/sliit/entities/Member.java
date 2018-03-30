package com.sliit.entities;

import java.io.Serializable;
import java.sql.Date;


public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static int REGULAR_MEMBER = 0;
	public static int COMMUNITY_ADMIN = 1;
	public static int OWNER = 2;
	
	private int id;
	
	private String email;
	private String fname;
	private String lname;
	private String password;
	private String address;
	private String mobile;
	private String homeTel;
	private Date dob;
	private int userLevel;
	private String verificationCode;
	
		
	public Member() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHomeTel() {
		return homeTel;
	}
	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", password="
				+ password + ", address=" + address + ", mobile=" + mobile + ", homeTel=" + homeTel + ", dob=" + dob
				+ ", userLevel=" + userLevel + ", verificationCode=" + verificationCode + "]";
	}
	
	public String getFullName() {
		
		return fname + " " +lname;
	}

}
