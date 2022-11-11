package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.CourseException;

public class DeleteCourse {
	public void deletecourse() {
		System.out.println("want to delete any course.....\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseName :- ");
		String coursename = sc.next();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			admin.deleteCourse(coursename);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
