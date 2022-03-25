package dao;

import pojos.Course;

public interface ICourseDao {
	// launch new course
	String launchNewCourse(Course c);

	// cancel the course
	String cancelCourse(int courseId);

	// get course details
	Course getCourseDetails(String title);

	// get course and students details : using a hint : size()
	 Course getCourseStudentDetails(String title);
	 
	// get course and students details : using single join quert
		 Course getCourseStudentDetailsJoinFetxh(String title);
}