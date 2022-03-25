package dao;

import java.util.Set;

import pojos.Course;
import pojos.Project;
import pojos.Student;

public interface IProjectDao {
	// launch new project
	String launchNewProject(Project pr);

	// add student to a project
	String addStudentToProject(int projectId, int studentId);

	// remove student from a project
	String removeStudentFromProject(int projectId, int studentId);

	// Display student names , from specified project title
	Set<Student> getCourseStudentDetails(String projectName);
}
