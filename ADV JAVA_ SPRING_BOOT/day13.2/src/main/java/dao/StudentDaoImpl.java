package dao;

import pojos.Course;
import pojos.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitNewStudent(String courseName, Student student) {
		String mesg = "student admission failed";
		String jpql = "select c from Course c where c.title=:title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get course from course name : JPQL
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			// => course found, c : PERSISTENT
			// establish birirectional link using helper method
			c.addStudent(student);
			// session.persist(student); // explicitly savign student details
			tx.commit();
			mesg = "student " + student.getName() + " admitted to course " + courseName;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseName, int studentId) {
		String mesg = "student admission  cancellation failed";
		String jpql = "select c from Course c where c.title=:title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get course from course name : JPQL
			Course c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			// => course found, c : PERSISTENT
			Student s = session.get(Student.class, studentId);
			if (s != null) {
				// remove bi directional link : removeStudent
				c.removeStudent(s);
				mesg = "student "+ s.getName()+" admission cancelled";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
