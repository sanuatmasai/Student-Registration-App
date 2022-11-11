package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.CourseException;
import com.masai.model.Course;

public class GetCourse {
	public static void main(String[] args) {
		System.out.println("get details of course.....");
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseName :- ");
		String coursename = sc.next();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			List<Course> courses = admin.getCourse(coursename);
			courses.forEach(c -> System.out.println(c));
		} catch (CourseException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
