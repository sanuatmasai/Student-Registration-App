package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.exceptions.StudentException;
import com.masai.model.Student;
import com.masai.utility.DBUtil;

public class StudentDAOimpl implements StudentDAO {

	@Override
	public String registerStudent(Student student) throws StudentException {
		String result = "Executing....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into student (username, password, name, age, Address, courseid) values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, student.getUsername());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getName());
			ps.setInt(4, student.getAge());
			ps.setString(5, student.getAddress());
			ps.setInt(6, student.getCourseid());
			
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

}
