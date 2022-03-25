package dao;

import pojos.Books;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

public class BookDaoImpl implements IBookDao {

	String mesg;

	@Override
	public String addBooks(Books book) {
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(book);
			tx.commit();
			mesg = "Book added successfully " + book.getTitle();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return mesg;
	}

	@Override
	public Books findById(int id) {
		Books book = null;
		Session session = getFactory().getCurrentSession();
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			book = session.get(Books.class, id);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return book;
	}

	@Override
	public List<Books> findByAuthor(String inauthor, LocalDate indateAfter) {
		List<Books> book = null;
		String jpql = "select b from Books b where b.author=:author and b.pubDate>:dateAfter order by b.price desc";
		Session session = getFactory().getCurrentSession();
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			book = session.createQuery(jpql, Books.class).setParameter("author", inauthor)
					.setParameter("dateAfter", indateAfter).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return book;
	}

	@Override
	public String discountApplied(LocalDate date, double discount) {
		String mesg = "Failed";
		List<Books> book;
		double price, newPrice, count=0;
		String jpql = "select b from Books b where b.pubDate<:indate";
		Session session = getFactory().getCurrentSession();
		// beging transaction
		Transaction tx = session.beginTransaction();
		try {
			book = session.createQuery(jpql, Books.class).setParameter("indate", date).getResultList();
			for (Books b : book) {
				price = b.getPrice();
				newPrice = price - (price *(discount/100));
				b.setPrice(newPrice);
				count++;
			}
			tx.commit();
			mesg = "price updated in "+count+"books";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
