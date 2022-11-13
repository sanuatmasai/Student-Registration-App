package com.masai.model;

public class Student_Batch {
	public Student_Batch(int studentid, int batchid) {
		super();
		this.studentid = studentid;
		this.batchid = batchid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	@Override
	public String toString() {
		return 
//				"Student_Batch [studentid=" + studentid + ", batchid=" + batchid + "]";
		
		      "   +-------------------------------+\r\n"
			+ "   |  studentid = " + studentid    +"|\r\n"   
			+ "   |  batchid = " + batchid        +"|\r\n" 
			+ "   +------------------------------ +";
	}

	int studentid;
	int batchid;
	
	public Student_Batch() {
		
	}
	
}
