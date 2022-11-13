package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.AdminException;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Admin;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.utility.DBUtil;

public class AdminstratorDAOimpl implements AdminstratorDAO {

	@Override
	public String addCourse(Course course) throws CourseException {
		String result = "Executing....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into course (courseid, coursename, price, duration) values (?, ?, ?, ?)");
			ps.setInt(1, course.getCourseid());
			ps.setString(2, course.getCoursename());
			ps.setInt(3, course.getPrice());
			ps.setInt(4, course.getDurationDays());
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println(x + " course has been added");
				result = "Executed";
			}else {
				throw new CourseException("None of the course has been added");
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		return result;
	}

	@Override
	public String updateFee(String courseName, int amount) throws CourseException {
		String result = "Executing...";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update course set price = price + ? where coursename = ?");
			ps.setInt(1, amount);
			ps.setString(2, courseName);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println(x + " coursePrice has been updated");
				result = "Executed";
			}else {
				throw new CourseException("None of the coursePrice has been updated");
			}

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		return result;
	}

	@Override
	public String deleteCourse(String courseName) throws CourseException {
		String result = "Executing...";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete from course where coursename = ?");
			ps.setString(1, courseName);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println(x + " course has been deleted");
				result = "Executed";
			}else {
				throw new CourseException("None of the course has been deleted");
			}

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Course> getCourse(String courseName) throws CourseException {
		List<Course> courses = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from course where coursename = ?");
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				courses.add(new Course(rs.getInt("courseid"), rs.getString("coursename"), rs.getInt("price"), rs.getInt("duration")));
			}
			
			if(courses.size() == 0){
				throw new CourseException("No course is available");
			}
			System.out.println(courses.size() + " courses available......");

		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		return courses;
	}

	@Override
	public String addBatchUnderCourse(Batch batch) throws BatchException {
		String result = "Executing....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into batch(courseId, instructor, strength, max_capacity, duration_in_hour) values (?, ?, ?, ?, ?)");
			ps.setInt(1, batch.getCourseid());
			ps.setString(2, batch.getInstructor());
			ps.setInt(3, batch.getStrength());
			ps.setInt(4, batch.getMax_capacity());
			ps.setInt(5, batch.getDuration());
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println(x + " batch has been added under courseId :-" + batch.getCourseid());
				result = "Executed";
			}else {
				throw new BatchException("None of the batch has been added");
			}
		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		return result;
	}

	@Override
	public String updateTotalSeats(int batchid, int additionalSeat) throws BatchException {
		String result = "Executing...";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update batch set max_capacity = max_capacity + ? where batchid = ?");
			ps.setInt(1, additionalSeat);
			ps.setInt(2, batchid);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				System.out.println("Total seats of batchid :- " + batchid +" has been updated");
				result = "Executed";
			}else {
				throw new BatchException("None of the data has been updated");
			}

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Student> getStudentByBatch(int batchid) throws StudentException {
		List<Student> students = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where studentId IN (select studentid from Student_batch where batchid = ?)");
			ps.setInt(1, batchid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				int studentId = rs.getInt("studentId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				int courseId = rs.getInt("Courseid");
				boolean isbatchalloted = rs.getBoolean("isbatchalloted");
				
				students.add(new Student(username, password, studentId, name, age, address, courseId, isbatchalloted));
			}
			
			if(students.size() == 0){
				throw new StudentException("No student is available");
			}
			System.out.println(students.size() + " students available......");

		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		return students;
	}

	@Override
	public List<Integer> getStudentByCourse(int courseId) throws StudentException, BatchException {
		List<Integer> batchIds = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select Batchid from batch where courseid = ?");
			ps.setInt(1, courseId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				batchIds.add(rs.getInt("batchid"));
				System.out.println("students in BatchId :- " + rs.getInt("batchid"));
				try {
					List<Student> students = new AdminstratorDAOimpl().getStudentByBatch(rs.getInt("batchid"));
					students.forEach(s -> System.out.println(s));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("--------------------------------------");	
			}
			
			if(batchIds.size() == 0){
				throw new StudentException("No batch is available");
			}
			System.out.println(batchIds.size() + " batches were available......");

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		return batchIds;
	}

	@Override
	public List<Batch> getAvailabBatchs(int studentId) throws BatchException {
		List<Batch> batches = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select batchid, instructor, duration_in_hour, (max_capacity - strength) seat_available from batch where courseid = (select courseid from student where studentId = ?)");
			ps.setInt(1, studentId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Batch batch = new Batch();
				batch.setBatchid(rs.getInt("batchid")); 
				batch.setInstructor(rs.getString("instructor"));
				batch.setDuration(rs.getInt("duration_in_hour"));
				int seat_available = rs.getInt("seat_available");
				
				if(seat_available > 0) {
					batches.add(batch);
				} 
//			System.out.println("[ BatchId :- "+ batch.getBatchid()+ ", " + "Instructor :- "+ batch.getInstructor()+ ", "+ "Class Duration :- "+                                                batch.getDuration()+ ", "+ " seats_available :-  " + seat_available + " ]" ); 
				
			System.out.println(		
						      "   +----------------------------------------+\r\n"
							+ "   |  batchid = " + batch.getBatchid()      +"|\r\n"   
							+ "   |  instructor = " + batch.getInstructor()+"|\r\n" 
							+ "   |  seats_available = " + seat_available  +"|\r\n" 
							+ "   |  duration = " + batch.getDuration()    +"|\r\n" 
							+ "   +----------------------------------------+");
				
			}
			
			if(batches.size() == 0){
				throw new BatchException("No batch is available");
			}
			System.out.println(batches.size() + " batches available......");

		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		return batches;
	}

	@Override
	public String allocateBatch(int studentId, int batchId) throws StudentException {
        // check from the main class that it is a valid batchid
		String result = "Executing....";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select isbatchAlloted from student where studentid = ?");
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(!rs.getBoolean("isbatchalloted")) {
					PreparedStatement ps1 = conn.prepareStatement("update student set isbatchAlloted = true where studentid = ?");
					ps1.setInt(1, studentId);
					
					PreparedStatement ps2 = conn.prepareStatement("update batch set strength = strength + 1 where batchid = ?");
					ps2.setInt(1, batchId);
					
					
					PreparedStatement ps3 = conn.prepareStatement("insert into student_batch (studentid, batchid) values (?, ?)");
					ps3.setInt(1, studentId);
					ps3.setInt(2, batchId);
					
					
					ps2.executeUpdate();
					ps3.executeUpdate();
					int x = ps1.executeUpdate();
					
					if(x > 0) {
						System.out.println("student with studentId " + studentId + " has been alloted in the bath with batchId " + batchId);
						result = "executed";
					} else {
						throw new StudentException("No batch has been alloted....");
					}
				} else {
					System.out.println("Student with ID " + studentId + " has already been allocated to a batch.");
				}
			} else {
				throw new StudentException("No Student is Available with this ID.");
			}
				
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Admin knowAdminId(String username, String password) throws AdminException {
		Admin admin = null;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("adminid"));
				admin.setName(rs.getString("name"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setAddress(rs.getString("address"));
				admin.setPhone(rs.getInt("phoneNo"));
				
			}else {
				throw new AdminException("Invalid credentials..!");
			}
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		return admin;
	}
}
