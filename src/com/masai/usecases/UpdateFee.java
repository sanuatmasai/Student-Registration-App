package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.CourseException;

public class UpdateFee {
	public void updatefee(){
		System.out.println("want to update fee of the course.....\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseName :- ");
		String coursename = sc.next();
		System.out.print("increment amount :- ");
		int increment = sc.nextInt();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			admin.updateFee(coursename, increment);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
