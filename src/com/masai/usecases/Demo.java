package com.masai.usecases;

import java.util.Scanner;
import com.masai.model.Student;

public class Demo {

	public static void main(String[] args) {
		while(true) {
			System.out.println("   +-----------------------------------------+\r\n"
					         + "   | 1.Register yourself as Student          |\r\n"
					         + "   | 2.Login in as Student                   |\r\n"
					         + "   | 3.Login as Admin                        |\r\n"
					         + "   | 4.Exit                                  |\r\n"
					         + "   +-----------------------------------------+");
			System.out.print("You are on the Home Page?\n"
					+"\n"
					+"Enter Your Choice :- ");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if(input == 1) {
				RegisterStudent rs = new RegisterStudent();
				Student student = rs.Registration();
				int studentId = student.getStudentid();
				System.out.println();
				System.out.println("   +-------------------------------+\r\n"
						         + "   | 1. For Batch Allotment.       |\r\n"
						         + "   | 2. Remind me Later.           |\r\n"
						         + "   | 3. Know about us.             |\r\n"
						         + "   | 4. Go Home.                   |\r\n"
						         + "   +-------------------------------+");
				boolean flag = true;
				while(flag) {
					System.out.print("Enter Your Choice :- ");
					int again_input = sc.nextInt();
					if(again_input == 1) {
						AllocateBatch ab = new AllocateBatch();
						ab.allocateBatch(studentId);
						
						flag = false;
					}else if(again_input == 2) {
						System.out.println("Thanks for Showing your interest in us \n we will surely remind you Later......!!");
						flag = false;
					}else if(again_input == 3) {
						System.out.println("   +------------------------------------------------------------------------------------------------------+\n"
										  +"   |                        Masai & N.S.D.C. Announce Strategic Partnership.                              |\n"
										  +"   | The partnership with National Skill Development Corporation has the potential to                     |\n"
										  +"   | create equal employment opportunity for India’s youth, narrowing the gap between the demand          |\n"
										  +"   | and supply of skilled manpower for the private-sector job market. This collaboration will change     |\n"
										  +"   |  the way skill-based education is delivered in India.                                                |\n"
										  +"   +------------------------------------------------------------------------------------------------------+");
						flag = false;
					}else if(again_input == 4) {
						flag = false;
					}else {
						System.out.println("Invalid Input...!!");
					}
				}
			}else if (input == 2) {
				LoginCheckStudent lcs = new LoginCheckStudent();
				lcs.logincheck();
			}else if(input == 3) {
				LoginCheckAdmin lca = new LoginCheckAdmin();
				lca.logincheck();
			}else if(input == 4) {
				System.out.println("ThanKYou...!!");
				break;
			} else {
				System.out.println("Invalid Input...!!");
			}
		}
		
	}
}
