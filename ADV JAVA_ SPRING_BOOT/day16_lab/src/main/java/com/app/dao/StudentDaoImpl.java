package com.app.dao;

import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;
import com.app.pojos.Project;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@Autowired // => byType
	private SessionFactory sf;
	
	@Override
	public Set<Student> getCourseStudentDetails(String projectName) {
		Set<Student> students = null;
		String jpql = "select p from Project p join fetch p.students where p.title=:title";
		students = sf.getCurrentSession().createQuery(jpql, Project.class).setParameter("title", projectName).getSingleResult().getStudents();
		return students;
	}

}
