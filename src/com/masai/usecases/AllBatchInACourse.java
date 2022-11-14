package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.BatchException;

public class AllBatchInACourse {
	public static void main() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter BatchId :- ");
		int n = sc.nextInt();
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			admin.getallbBatchsInABatch(n);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}
	}
}
