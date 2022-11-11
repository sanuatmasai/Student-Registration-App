package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.CourseException;

public class DeleteCourse {
	public static void main(String[] args) {
		System.out.println("want to delete any course.....");
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseName :- ");
		String coursename = sc.next();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			System.out.println(admin.deleteCourse(coursename));
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
