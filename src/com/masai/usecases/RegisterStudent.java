package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOimpl;
import com.masai.exceptions.StudentException;
import com.masai.model.Student;

public class RegisterStudent {
	public Student Registration() {
		Student student1 = null;
		System.out.println("Want to register Yourself, provide details...\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Username :- ");
		String username = sc.next();
		System.out.print("password :- ");
		String password = sc.next();
		System.out.print("Name :- ");
		String name = sc.next();
		System.out.print("age :- ");
		int age = sc.nextInt();
		System.out.print("address :- ");
		String address = sc.next();
		System.out.println("Choose your desired Course from the List........");
		System.out.println("_______________________________");
		GetAllCourses gal = new GetAllCourses();
		gal.getAllCourses();
		System.out.print("Enter CourseId :- ");
		int courseid = sc.nextInt();
		
		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		student.setName(name);
		student.setAge(age);
		student.setAddress(address);
		student.setCourseid(courseid);
		
		StudentDAO stud = new StudentDAOimpl();
		try {
			stud.registerStudent(student);
			student1 = stud.knowStudentId(username, password);
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		return student1;
	}
	
}
