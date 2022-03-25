package dao;

import static utils.HibernateUtils.getFactory;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Project;
import pojos.Student;

public class ProjectDaoImpl implements IProjectDao {

	@Override
	public String launchNewProject(Project pr) {
		String mesg ="Project launch failed";
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		//beging transaction
		Transaction tx = session.beginTransaction();
		try {
			session.persist(pr);
			tx.commit();
			mesg = "Launched new course with ID= " + pr.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String addStudentToProject(int projectId, int studentId) {
		String mesg = "Student NOT added to Project";
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		//beging transaction
		Transaction tx = session.beginTransaction();
		try {
			Project p = session.get(Project.class, projectId);
			Student s = session.get(Student.class, studentId);
			if(p!=null && s!=null) {
				p.addStudent(s);
				mesg = "Student added to Project";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String removeStudentFromProject(int projectId, int studentId) {
		String mesg = "Student removal failed";
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		//beging transaction
		Transaction tx = session.beginTransaction();
		try {
			Project p = session.get(Project.class, projectId);
			Student s = session.get(Student.class, studentId);
			if(p!=null && s!=null) {
				p.removeStudent(s);
				mesg = "Student Removed from Project";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Set<Student> getCourseStudentDetails(String projectName) {
		Set<Student> students = null;
		String jpql = "select p from Project p join fetch p.students where p.title=:title";
		// get sessionfrom sessionFactory : get current session
		Session session = getFactory().getCurrentSession();
		//beging transaction
		Transaction tx = session.beginTransaction();
		try {
			students = session.createQuery(jpql, Project.class).setParameter("title", projectName).getSingleResult().getStudents();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return students;
	}
}