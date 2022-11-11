package com.masai.usecases;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOimpl;
import com.masai.exceptions.CourseException;

public class GetAllCourses {
	public void getAllCourses() {
		System.out.println("Course Details......\n");
		StudentDAO student = new StudentDAOimpl();
		
		try {
			student.getAllCourses();
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
