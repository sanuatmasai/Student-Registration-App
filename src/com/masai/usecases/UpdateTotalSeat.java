package com.masai.usecases;
import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.BatchException;

public class UpdateTotalSeat {
	public void updateTotalSeat() {
		System.out.println("want to update total_seats of the batch.....\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("BatchId :- ");
		int bathId = sc.nextInt();
		System.out.print("increment seats :- ");
		int increment = sc.nextInt();
		
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			admin.updateTotalSeats(bathId, increment);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}
	}
}
