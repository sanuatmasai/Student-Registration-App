package com.masai.usecases;

import java.util.Scanner;
import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.AdminException;
import com.masai.model.Admin;

public class LoginCheckAdmin {
	public void logincheck() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Username :- ");
		String username = sc.next();
		System.out.print("Enter Password :- ");
		String password = sc.next();
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			Admin admin1 = admin.knowAdminId(username, password);
			System.out.println("Login successfull");
			System.out.println("hello "+ admin1.getName()+ " welcome to Masai.....");
			System.out.println();
			
//			System.out.println("   +------------------------------------------------------------------+\r\n"
//							  +"   |   1. Add a new course                                            |\r\n"
//							  +"   |   2. Update fees of course                                       |\r\n"
//							  +"   |   3. Delete a Course                                             |\r\n"
//							  +"   |   4. Get a Course                                                |\r\n"
//							  +"   |   5. Create Batch Under Course                                   |\r\n"
//							  +"   |   6. Allocate Student Batch within a Course                      |\r\n"
//							  +"   |   7. Update Total Seat of a Batch                                |\r\n"
//							  +"   |   8. view details of student Matrix in each course and batch     |\r\n"
//							  +"   |   9. Log Out                                                     |\r\n"
//							  +"   +------------------------------------------------------------------+");
//			
			while(true) {
				System.out.println("   +------------------------------------------------------------------+\r\n"
								  +"   |   1. Add a new course                                            |\r\n"
								  +"   |   2. Update fees of course                                       |\r\n"
								  +"   |   3. Delete a Course                                             |\r\n"
								  +"   |   4. Get a Course                                                |\r\n"
								  +"   |   5. Create Batch Under Course                                   |\r\n"
								  +"   |   6. Allocate Student Batch within a Course                      |\r\n"
								  +"   |   7. Update Total Seat of a Batch                                |\r\n"
								  +"   |   8. view details of student Matrix in each course and batch     |\r\n"
								  +"   |   9. Log Out                                                     |\r\n"
								  +"   +------------------------------------------------------------------+");
		
				System.out.print(admin1.getName() +" what you want to perform ?\n"
						+"\n"
						+ "Enter Your Choice :- ");
				int input = sc.nextInt();
				if(input == 1) {
					AddCourse ac = new AddCourse();
					ac.addcourse();
				}else if(input == 2) {
					UpdateFee uf = new UpdateFee();
					uf.updatefee();
				}else if(input == 3) {
					DeleteCourse dc = new DeleteCourse();
					dc.deletecourse();
				}else if(input == 4) {
					GetCourse gc = new GetCourse();
					gc.getcourse();
				}else if(input == 5) {
					AddBranchUnderCourse abc = new AddBranchUnderCourse();
					abc.addbatch();
				}else if(input == 6) {
					System.out.print("Enter StudentId :- ");
					int studentId = sc.nextInt();
					AllocateBatch ab = new AllocateBatch();
					ab.allocateBatch(studentId);
				}else if(input == 7) {
					UpdateTotalSeat uts = new UpdateTotalSeat();
					uts.updateTotalSeat();
				}else if(input == 8) {
					GetStudents gc = new GetStudents();
					gc.getStudentMatrix();
				}else if(input == 9) {
					System.out.println("Log_Out Successfull....!");
					break;
				}else {
					System.out.println("Invalid Input....!!");
				}
			}	
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
	}
}
