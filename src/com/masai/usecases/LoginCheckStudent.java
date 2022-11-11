package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.StudentDAO;
import com.masai.dao.StudentDAOimpl;
import com.masai.exceptions.StudentException;
import com.masai.model.Student;

public class LoginCheckStudent {
	public void logincheck() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Username :- ");
		String username = sc.next();
		System.out.print("Enter Password :- ");
		String password = sc.next();
		StudentDAO stud = new StudentDAOimpl();
		try {
			Student student = stud.knowStudentId(username, password);
			System.out.println("Login successfull");
			System.out.println("hello "+ student.getName()+ " welcome to Masai.....");
			System.out.println();
			
			System.out.println("1. update username\r\n"
					+ "2. update password\r\n"
					+ "3. update name\r\n"
					+ "4. update address\r\n"
					+ "5. update age\r\n"
					+ "6. Log Out\n");
			
			while(true) {
				System.out.println("_______________________________\n");
				System.out.print("Enter Your Choice :- ");
				int input = sc.nextInt();
				if(input == 1) {
					System.out.print("Enter new username :- ");
					stud.upadteData(input, sc.next(), username, password);	
				}else if(input == 2) {
					System.out.print("Enter new password :- ");
					stud.upadteData(input, sc.next(), username, password);	
				}else if(input == 3) {
					System.out.print("Enter new name :- ");
					stud.upadteData(input, sc.next(), username, password);	
				}else if(input == 4) {
					System.out.print("Enter new address :- ");
					stud.upadteData(input, sc.next(), username, password);	
				}else if(input == 5) {
					System.out.print("Enter new age :- ");
					stud.upadteData(input, sc.nextInt(), username, password);	
				}else if(input == 6) {
					System.out.println("Log_Out Successfull....!");
					break;
				} else {
					System.out.println("Invalid Input....!!");
				}
			}	
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
	}
}
