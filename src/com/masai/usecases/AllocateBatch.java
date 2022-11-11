package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.model.Batch;

public class AllocateBatch {
	public static void main(String[] args) {
		System.out.println("want to allocate batch to student.......");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter_StudentId :- ");
		int studentid = sc.nextInt();
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			List<Batch> batches = admin.getAvailabBatchs(studentid);
			
			System.out.println("choose your desired batch....");
			System.out.print("Enter_batchId :- ");
			int batchid = sc.nextInt();
			boolean flag = false;
			for(Batch batch : batches) {
				if(batch.getBatchid() == batchid) {
					flag = true;
					break;
				}
			}
			if(flag) {
//				System.out.println("flag is true");
				admin.allocateBatch(studentid, batchid);
			} else {
				System.out.println("Enter valid batchId....");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
