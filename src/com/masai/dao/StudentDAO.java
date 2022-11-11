package com.masai.dao;

import com.masai.exceptions.StudentException;
import com.masai.model.Student;

public interface StudentDAO {
	public String registerStudent(Student student) throws StudentException;
}
