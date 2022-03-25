package com.app.dao;

import java.util.Set;

import com.app.pojos.Student;

public interface IStudentDao {
	Set<Student> getCourseStudentDetails(String projectName);
}
