package com.masai.model;

public class Batch {
	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getStrength() {
		return strength;
	}

	public int getMax_capacity() {
		return max_capacity;
	}

	public void setMax_capacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Batch(int batchid, int courseid, String instructor, int strength, int max_capacity, int duration) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.instructor = instructor;
		this.strength = strength;
		this.max_capacity = max_capacity;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return 
//		"Batch [batchid=" + batchid + ", courseid=" + courseid + ", instructor=" + instructor + ", strength="
//				+ strength + ", max_capacity=" + max_capacity + ", duration=" + duration + "]";
		
		 "   +----------------------------------+\r\n"
		+"   |  batchid = " + batchid           +"|\r\n"   
		+"   |  courseid = " + courseid         +"|\r\n" 
		+"   |  instructor =" + instructor     +"|\r\n" 
		+"   |  strength = " + strength         +"|\r\n" 
		+"   |  max_capacity = " + max_capacity +"|\r\n" 
		+"   |  duration = " + duration         +"|\r\n" 
		+"   +----------------------------------+";
	}

	private int batchid;
	private int courseid;
	private String instructor;
	private int strength = 0;
	private int max_capacity;
	private int duration;
	
	public Batch() {
		
	}
}
