package com.masai.model;

public class Admin {
	@Override
	public String toString() {
		return    "   +----------------------------------+\r\n"
				+ "   |  adminId = " + adminId           +"\r\n"   
				+ "   |  name = " + name                 +"\r\n" 
				+ "   |  username = " + username         +"\r\n" 
				+ "   |  password = " + password         +"\r\n" 
				+ "   |  address = " + address           +"\r\n" 
				+ "   |  phone = " + phone               +"\r\n" 
				+ "   +----------------------------------+";
		
	}
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Admin(int adminId, String name, String username, String password, String address, int phone) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
	}

	private int adminId;
	private String name;
	private String username;
	public String password;
	private String address;
	private int phone;
	
	public Admin() {
		
	}
	
}
