package com.kh.practice1.model;

public class UserInfo {
	
	public int userNo;
	public String id;
	public String password;
	public String email;
	public String name;
	public String phone;
	public String addr;

	public UserInfo () {}
	
	//public UserInfo (String name) {this.name = name;}
	
	public void changeName (String name) {
		this.name = name;}
	
	public String printName () {
		return this.name ;}
	}
	
	/*public UserInfo (int userNo, String id, String password, String email, String name, String phone, String addr) {
		this.userNo = userNo;
		this.id =id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}*/
