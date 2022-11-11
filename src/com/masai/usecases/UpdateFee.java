package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.CourseException;

public class UpdateFee {
	public static void main(String[] args) {
		System.out.println("want to update fee of the course.....");
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseName :- ");
		String coursename = sc.next();
		System.out.print("increment amount :- ");
		int increment = sc.nextInt();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			System.out.println(admin.updateFee(coursename, increment));
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}
	}
}
