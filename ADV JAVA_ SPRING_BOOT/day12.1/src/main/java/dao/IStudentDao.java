package dao;

import pojos.Student;

public interface IStudentDao {
	// student admission
	String admitNewStudent(String courseName, Student student);

	// cancel specific student's admission from a specific course
	String cancelAdmission(String courseName, int studentId);
}
