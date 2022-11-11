package com.masai.dao;

import java.util.List;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;

public interface StudentDAO {
	public String registerStudent(Student student) throws StudentException;
	public List<Course> getAllCourses() throws CourseException; 
	
	public Student knowStudentId(String username, String password) throws StudentException;
	public String upadteData(int value, Object key, String username, String password) throws StudentException;
}
