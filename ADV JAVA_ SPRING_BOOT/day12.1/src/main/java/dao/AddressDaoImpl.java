package dao;

import pojos.Address;
import pojos.Student;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

public class AddressDaoImpl implements IAddressDao {

	@Override
	public String assignAddressDetails(int studentId, Address a) {
		String mesg = "linking address failed";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {

			// get student details by id
			Student s = session.get(Student.class, studentId);
			if (s != null) {
				// System.out.println(a.getStudent());// null
				// not null
				a.setStudent(s); // established unidirectional association from Address --> Student
				session.persist(a);
				mesg = "linking address done for student " + s.getName();
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
