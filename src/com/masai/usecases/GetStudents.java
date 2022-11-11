package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.StudentException;
import com.masai.model.Student;

public class GetStudents {
	public static void main(String[] args) {
		System.out.println("Get all the student of particular batch......");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("give batchId :- ");
		int batchid = sc.nextInt();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			List<Student> students = admin.getStudentByBatch(batchid);
			students.forEach(s -> System.out.println(s));
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Get all the student in particular course......");
		System.out.print("give courseId :- ");
		int courseid = sc.nextInt();
		try {
			admin.getStudentByCourse(courseid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
