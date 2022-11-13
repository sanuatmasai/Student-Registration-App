package com.masai.model;

public class Student {
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

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public boolean getisBatchAllowed() {
		return isBatchAlloted;
	}

//	public void setBatchAllowed(boolean isBatchAllowed) {
//		this.isBatchAllowed = isBatchAllowed;
//	}

	public Student(String username, String password, int studentid, String name, int age, String address, int courseid,
			boolean isBatchAllowed) {
		super();
		this.username = username;
		this.password = password;
		this.studentid = studentid;
		this.name = name;
		this.age = age;
		this.address = address;
		this.courseid = courseid;
		this.isBatchAlloted = isBatchAllowed;
	}

	@Override
	public String toString() {
		return 
//				"Student [username=" + username + ", password=" + password + ", studentid=" + studentid + ", name="
//				+ name + ", age=" + age + ", address=" + address + ", courseid=" + courseid + ", isBatchAlloted="
//				+ isBatchAlloted + "]";
		
		
		
		  "   +----------------------------------------+\r\n"
		+ "   |  username=" + username               +"|\r\n"   
		+ "   |  password=" + password               +"|\r\n" 
		+ "   |  studentid=" + studentid             +"|\r\n" 
		+ "   |  name=" + name                       +"|\r\n" 
		+ "   |  age=" + age                         +"|\r\n" 
		+ "   |  address=" + address                 +"|\r\n" 
		+ "   |  courseid=" + courseid               +"|\r\n" 
		+ "   |  isBatchAlloted=" + isBatchAlloted   +"|\r\n" 
		+ "   +----------------------------------------+";
	}

	private String username;
	private String password;
	private int studentid;
	private String name;
	private int age;
	private String address;
	private int courseid;
	private boolean isBatchAlloted = false;
	
	public Student() {
		
	}
}
