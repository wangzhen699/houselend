package com.house.entity;

/**
 * 
 * @Description 租房用户
 */
public class Users {

	private int uID;
	private String uName;
	private String uPassword;
	private String uPhoneNumber;
	private String uNickName;
	String name;
	String sid;
	String email;
	String qq;
	String wechat;
	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuPhoneNumber() {
		return uPhoneNumber;
	}

	public void setuPhoneNumber(String uPhoneNumber) {
		this.uPhoneNumber = uPhoneNumber;
	}

	public String getuNickName() {
		return uNickName;
	}

	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}

	public Users(int uID, String uName, String uPassword, String uPhoneNumber, String uNickName) {
		super();
		this.uID = uID;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uPhoneNumber = uPhoneNumber;
		this.uNickName = uNickName;
	}

	public Users() {
		super();
	}

	public Users(String uName, String uPassword, String uPhoneNumber, String uNickName) {
		super();
		this.uName = uName;
		this.uPassword = uPassword;
		this.uPhoneNumber = uPhoneNumber;
		this.uNickName = uNickName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

}
