package com.masai.dao;

import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Admin;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Student;

public interface AdminstratorDAO {
	public String addCourse(Course course) throws CourseException;
	public String updateFee(String courseName, int amount) throws CourseException;
	public String deleteCourse(String courseName) throws CourseException; 
	public List<Course> getCourse(String courseName) throws CourseException;
	public String addBatchUnderCourse(Batch batch) throws BatchException;
	public String updateTotalSeats(int batchid, int additionalSeat) throws BatchException;
	
	
	public List<Student> getStudentByBatch(int batchid) throws StudentException;
	public List<Integer> getStudentByCourse(int courseId) throws StudentException, BatchException;
	
	
	public List<Batch> getAvailabBatchs(int studentId) throws BatchException; 
	public String allocateBatch(int studentId, int batchId) throws StudentException;
	
	public Admin knowAdminId(String username, String password) throws AdminException;
	public List<Batch> getallbBatchsInABatch(int corseId) throws BatchException; 
}
