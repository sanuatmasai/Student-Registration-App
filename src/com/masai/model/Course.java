package com.masai.model;

public class Course {
	@Override
	public String toString() {
		return 
//				"Course [courseid=" + courseid + ", coursename=" + coursename + ", price=" + price + ", durationDays="
//				+ durationDays + "]";
		
		
		
		  "   +--------------------------------------+\r\n"
		+ "   |  courseid=" + courseid              +"\r\n"   
		+ "   |  coursename=" + coursename          +"\r\n" 
		+ "   |  price=" + price                    +"\r\n" 
		+ "   |  duration_in_Days=" + durationDays  +"\r\n" 
		+ "   +--------------------------------------+";
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

	public Course(int courseid, String coursename, int price, int durationDays) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.price = price;
		this.durationDays = durationDays;
	}

	private int courseid;
	private String coursename;
	private int price;
	private int durationDays;
	
	public Course() {
		
	}
}
