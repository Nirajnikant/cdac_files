package dao;

import static utils.HibernateUtils.getFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		String mesg = "Course launching failed!!!";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(c);
			tx.commit();
			mesg = "Launched new course with ID= " + c.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelCourse(int courseId) {
		String mesg = "Cancel course FAILED!!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get course from it's id
			Course c = session.get(Course.class, courseId);
			if (c != null) {
				// delete the course
				session.delete(c); // c : mark for REMOVED
				mesg = "Course Cancelled with ID = " + courseId;
			}
			tx.commit(); // auto dirty checking : delete : child record first and then parent records
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String title) {
		Course c = null;
		String jpql = "select c from Course c where c.title=:title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();
			// c : PERSISTENT
			tx.commit(); // auto dirty checking : delete : child record first and then parent records

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c; // c : DETACHED
	}

	@Override
	public Course getCourseStudentDetails(String title) {
		Course c = null;
		String jpql = "select c from Course c where c.title=:title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();// select :
																										// course
			// c : PERSISTANT
			// simply access the size of collection, from within the session scope
			c.getStudents().size();// select : students
			tx.commit(); // auto dirty checking : delete : child record first and then parent records

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c; // c : DETACHED
	}

	@Override
	public Course getCourseStudentDetailsJoinFetxh(String title) {
		Course c = null;
		String jpql = "select c from Course c join fetch c.students where c.title=:title";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();// select :
																										// course

			tx.commit(); // auto dirty checking : delete : child record first and then parent records
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return null;
	}

}
