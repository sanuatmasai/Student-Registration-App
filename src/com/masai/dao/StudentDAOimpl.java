package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.utility.DBUtil;

public class StudentDAOimpl implements StudentDAO {

	@Override
	public String registerStudent(Student student) throws StudentException {
		String result = "Executing....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into student (username, password, name, age, Address, courseid, isbatchalloted) values (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, student.getUsername());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getName());
			ps.setInt(4, student.getAge());
			ps.setString(5, student.getAddress());
			ps.setInt(6, student.getCourseid());
			ps.setBoolean(7, student.getisBatchAllowed());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println(x + " Student has been registered into courseId :- " + student.getCourseid());
				result = "Executed";
			}else {
				throw new StudentException("None of the Student has been added");
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		return result;
	}

	@Override
	public List<Course> getAllCourses() throws CourseException {
		List<Course> courses = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select c.courseid, c.coursename, c.price, c.duration, count(b.batchid) number_of_Batch, (sum(b.max_capacity) - sum(b.strength)) seat_available from course c, batch b where c.courseid = b.courseid group by c.courseid");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Course course = new Course(rs.getInt("courseid"), rs.getString("coursename"), rs.getInt("price"), rs.getInt("duration"));
				System.out.println(course);
				courses.add(course);
				
				System.out.println(" seats_available in the course :- " + rs.getInt("seat_available"));
				System.out.println("_____________________________________________________________");
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
	public Student knowStudentId(String username, String password) throws StudentException {
		Student student = null;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String username1 = rs.getString("username");
				String password1 = rs.getString("password");
				int studentId = rs.getInt("studentId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				int courseId = rs.getInt("Courseid");
				boolean isbatchalloted = rs.getBoolean("isbatchalloted");
				
				student = new Student(username1, password1, studentId, name, age, address, courseId, isbatchalloted);
			}else {
				throw new StudentException("Invalid credentials..!");
			}
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		return student;
	}

	@Override
	public String upadteData(int value, Object key, String username, String password) throws StudentException {
		String result = "updating....";
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = null;
			if(value == 1) {
				ps = conn.prepareStatement("update student set username = ? where username = ? and password = ?");
			}else if(value == 2) {
				ps = conn.prepareStatement("update student set password = ? where username = ? and password = ?");
			}else if(value == 3) {
				ps = conn.prepareStatement("update student set name = ? where username = ? and password = ?");
			}else if(value == 4) {
				ps = conn.prepareStatement("update student set address = ? where username = ? and password = ?");
			}else if(value == 5) {
				ps = conn.prepareStatement("update student set age = ? where username = ? and password = ?");
			}
			
			ps.setObject(1, key);
			ps.setString(2, username);
			ps.setString(3, password);
			int x = ps.executeUpdate();
			
			if(x > 0) {
				System.out.println(key + " updated.");
				result = "updated";
				
			}else {
				throw new StudentException(key + "Not updated..!");
			}
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		return result;
	}

	@Override
	public Student knowStudent(String username, String password) throws StudentException {
		Student student = null;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from student where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String username1 = rs.getString("username");
				String password1 = rs.getString("password");
				int studentId = rs.getInt("studentId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				int courseId = rs.getInt("Courseid");
				boolean isbatchalloted = rs.getBoolean("isbatchalloted");
				
				student = new Student(username1, password1, studentId, name, age, address, courseId, isbatchalloted);
			}else {
				throw new StudentException("Invalid credentials..!");
			}
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		return student;
	}
}
