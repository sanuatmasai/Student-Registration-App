package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.CourseException;
import com.masai.model.Course;

public class AddCourse {
	public void addcourse() {
		System.out.println("Want to Add courses, provide details...\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseId :- ");
		int courseId = sc.nextInt();
		System.out.print("CourseName :- ");
		String courseName = sc.next();
		System.out.print("price :- ");
		int price = sc.nextInt();
		System.out.print("Duration(days) :- ");
		int duration = sc.nextInt();
		
		Course course = new Course(courseId, courseName, price, duration);
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			admin.addCourse(course);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
