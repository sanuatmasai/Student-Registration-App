package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.AdminstratorDAO;
import com.masai.dao.AdminstratorDAOimpl;
import com.masai.exceptions.BatchException;
import com.masai.model.Batch;

public class AddBranchUnderCourse {
	public void addbatch() {
		System.out.println("Want to Add branches under course, provide details...\n");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("CourseId :- ");
		int courseId = sc.nextInt();
		System.out.print("Instructor :- ");
		String instructor = sc.next();
		System.out.print("max_capacity :- ");
		int capacity = sc.nextInt();
		System.out.print("Class_Duration(hr) :- ");
		int duration = sc.nextInt();
		
		Batch batch = new Batch();
		batch.setCourseid(courseId);
		batch.setInstructor(instructor);
		batch.setMax_capacity(capacity);
		batch.setDuration(duration);
		AdminstratorDAO admin = new AdminstratorDAOimpl();
		try {
			admin.addBatchUnderCourse(batch);
		} catch (BatchException e) {
			System.out.println(e.getMessage());
		}
	}
}
